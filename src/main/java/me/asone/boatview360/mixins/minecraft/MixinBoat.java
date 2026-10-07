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

package me.asone.boatview360.mixins.minecraft;

import org.spongepowered.asm.mixin.Mixin;

//? if <=1.21.1 {
/*import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import me.asone.boatview360.util.MathUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;

@Mixin(Boat.class)
public class MixinBoat {
	@Redirect(
			method = "clampRotation",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clamp(FFF)F")
	)
	private float modifyClamp(float value, float min, float max, Entity passenger) {
		return MathUtil.modifyClamp(value, min, max, passenger);
	}
}

*///?} else {
@Mixin(net.minecraft.client.Minecraft.class)
public class MixinBoat {}
//?}
