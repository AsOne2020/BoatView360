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

import me.asone.boatview360.util.MathUtil;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import org.spongepowered.asm.mixin.Mixin;

//#if MC >= 12102
import net.minecraft.entity.Entity;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
//#else
//$$ import org.spongepowered.asm.mixin.Pseudo;
//#endif

@Restriction(require = @Condition(value = "minecraft", versionPredicates = ">=1.21.2"))
//#if MC >= 12102
@Mixin(net.minecraft.entity.vehicle.AbstractBoatEntity.class)
//#else
//$$ @Pseudo
//$$ @Mixin(targets = "net.minecraft.entity.vehicle.AbstractBoatEntity")
//#endif
public class MixinAbstractBoatEntity {
	//#if MC >= 12102
	@Redirect(
			method = "clampPassengerYaw",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F")
	)
	private float modifyClamp(float value, float min, float max, Entity entity) {
		return MathUtil.modifyClamp(value, min, max, entity);
	}
	//#endif
}
