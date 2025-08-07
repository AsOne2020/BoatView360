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

package me.asone.boatview360.mixins.immersive_aircraft;

import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@SuppressWarnings("UnresolvedMixinReference")
@Restriction(require = @Condition(value = "immersive_aircraft"))
@Pseudo
@Mixin(targets = "immersive_aircraft.entity.VehicleEntity")
public class MixinVehicleEntity {
    @Redirect(
            method = "copyEntityData",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/class_3532;method_15363(FFF)F")
    )
    private float modifyClamp(float value, float min, float max, Entity entity) {
        if (entity instanceof PlayerEntity) {
            return value;
        }
        return MathHelper.clamp(value, min, max);
    }

}
