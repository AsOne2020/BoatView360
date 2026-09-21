# BoatView360

[🌏 简体中文](README.md)  |  [🌐 English](README_en.md)

[![Fabric](https://img.shields.io/badge/Mod%20Loader-Fabric-lightyellow)](https://fabricmc.net/)
[![Forge](https://img.shields.io/badge/Mod%20Loader-Forge-orange)](https://files.minecraftforge.net/)
[![NeoForge](https://img.shields.io/badge/Mod%20Loader-NeoForge-ff6600)](https://neoforged.net/)
[![MC Versions](http://cf.way2muchnoise.eu/versions/For%20MC_BoatView360_all.svg)](https://curseforge.com/minecraft/mc-mods/BoatView360)
[![CurseForge](http://cf.way2muchnoise.eu/full_BoatView360_downloads.svg)](https://curseforge.com/minecraft/mc-mods/BoatView360)
[![Modrinth](https://img.shields.io/modrinth/dt/BoatView360?color=00AF5C&logo=modrinth)](https://modrinth.com/mod/BoatView360)

## Introduction

**BoatView360** is a Fabric / Forge / NeoForge mod for Minecraft that removes the 210° rotation limit for boat passengers, allowing full **360° camera rotation** while seated in a boat.

In vanilla Minecraft, players seating in a boat can only rotate their view within ±105°, which limits situational awareness. This mod removes that restriction and enables players to freely look around in all directions.

## Features

- Removes the boat passenger rotation limit, enabling full 360° view
- Compatible with the following mods:
  - [Immersive Aircraft](https://modrinth.com/mod/immersive-aircraft)
  - [Immersive Machinery](https://modrinth.com/mod/immersive-machinery)
  - [Piggybacks](https://modrinth.com/mod/piggybacks)

## Usage

- **Client (Required)**  
  This mod **must be installed on the client** to enable unrestricted 360° view while riding a boat.

- **Server (Optional)**  
  Server installation is optional.  
  However, to ensure all players in multiplayer can see accurate 360° head rotations, it is recommended to install the mod on all three sides:
  - Your client
  - Other players' clients
  - The server

If any one of them is missing the mod, the 360° rotation effect will not be synchronized. Other players will still see your head rotation limited to the vanilla ±105° range.

## Credits

Thanks to the following projects:

- [fabric-mod-template](https://github.com/Fallen-Breath/fabric-mod-template)
- [stonecutter-template-fabric](https://github.com/stonecutter-versioning/stonecutter-template-fabric)
