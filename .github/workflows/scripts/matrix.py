"""
A script to scan through the versions directory and collect all folder names as the subproject list,
then output a json as the github action include matrix

The version-specific information (minecraft version, game versions, ...) is read from
`versions/<subproject>/gradle.properties`, and the mod-wide information from `gradle.properties`,
so that the release workflow does not need to parse those files itself.
"""
__author__ = 'Fallen_Breath'

import json
import os
import sys

# Properties that must exist in the root gradle.properties
REQUIRED_ROOT_PROPERTIES = ['mod.name', 'mod.version']
# Properties that must exist in every versions/<subproject>/gradle.properties
REQUIRED_VERSION_PROPERTIES = ['game_versions']
VALID_MOD_BRANDS = ['fabric', 'forge', 'neoforge']

ESCAPES = {'n': '\n', 'r': '\r', 't': '\t'}


def unescape(value: str) -> str:
	"""Resolve the escape sequences used in .properties values, e.g. `\\n`."""
	result = []
	escaped = False
	for char in value:
		if escaped:
			result.append(ESCAPES.get(char, char))
			escaped = False
		elif char == '\\':
			escaped = True
		else:
			result.append(char)
	if escaped:
		result.append('\\')
	return ''.join(result)


def read_properties(file_path: str) -> dict[str, str]:
	"""A minimal reader for the subset of the .properties format used by this repo."""
	properties: dict[str, str] = {}
	with open(file_path, encoding='utf-8') as f:
		for raw_line in f:
			line = raw_line.strip()
			if line == '' or line[0] in '#!':
				continue
			key, separator, value = line.partition('=')
			if separator == '':
				continue
			properties[key.strip()] = unescape(value.strip())
	return properties


def read_required_properties(file_path: str, required_keys: list[str]) -> dict[str, str]:
	properties = read_properties(file_path)
	for key in required_keys:
		if key not in properties or properties[key] == '':
			print('Missing property {} in {}'.format(key, file_path), file=sys.stderr)
			sys.exit(1)
	return properties


def main():
	target_subproject_env = os.environ.get('TARGET_SUBPROJECT', '')
	target_subprojects = [x for x in target_subproject_env.split(',') if x]
	print('target_subprojects: {}'.format(target_subprojects))

	root_properties = read_required_properties('gradle.properties', REQUIRED_ROOT_PROPERTIES)
	mod_name = root_properties['mod.name']
	mod_version = root_properties['mod.version']

	subprojects = sorted([
		name for name in os.listdir('versions')
		if os.path.isdir(os.path.join('versions', name))
	])

	if len(target_subprojects) == 0:
		selected_subprojects = subprojects
	else:
		selected_subprojects = []
		for subproject in subprojects:
			if subproject in target_subprojects:
				selected_subprojects.append(subproject)
				target_subprojects.remove(subproject)
		if len(target_subprojects) > 0:
			print('Unexpected subprojects: {}'.format(target_subprojects), file=sys.stderr)
			print('Available subprojects: {}'.format(subprojects), file=sys.stderr)
			sys.exit(1)

	matrix_entries = []
	for subproject in selected_subprojects:
		# the subproject directory is always named <minecraft_version>-<mod_brand>,
		# see the `version(...)` calls in settings.gradle
		mod_brand = subproject.rsplit('-', 1)[-1]
		if mod_brand not in VALID_MOD_BRANDS:
			print('Unsupported mod brand {} in subproject {}'.format(mod_brand, subproject), file=sys.stderr)
			sys.exit(1)

		properties_file = os.path.join('versions', subproject, 'gradle.properties')
		version_properties = read_required_properties(properties_file, REQUIRED_VERSION_PROPERTIES)

		matrix_entries.append({
			'subproject': subproject,
			'mod_brand': mod_brand,
			'minecraft_version': subproject.rsplit('-', 1)[0],
			# mc-publish takes one game version per line
			'game_versions': version_properties['game_versions'],
			'mod_name': mod_name,
			'mod_version': mod_version,
		})
	matrix = {'include': matrix_entries}
	with open(os.environ['GITHUB_OUTPUT'], 'w') as f:
		f.write('matrix={}\n'.format(json.dumps(matrix)))

	print('matrix:')
	print(json.dumps(matrix, indent=2))


if __name__ == '__main__':
	main()
