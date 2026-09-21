/*
 * This file is part of the BoatView360 project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2025  As_One and contributors
 *
 * BoatView360 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BoatView360 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with BoatView360.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.asone.boatview360;

//? fabric {
import net.fabricmc.api.ModInitializer;
//?} elif forge {
/*import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.LoadingModList;
*///?} elif neoforge {
/*import net.neoforged.fml.common.Mod;
*///?}

//? forgelike {
/*@Mod(BoatView360.MOD_ID)
*///?}
public class BoatView360
		//? fabric {
		implements ModInitializer
		//?}
{
	public static final String MOD_ID = "boatview360";

	//? fabric {
	@Override
	public void onInitialize() {
	}
	//?} elif forgelike {
	/*public BoatView360() {
	}
	*///?}
}
