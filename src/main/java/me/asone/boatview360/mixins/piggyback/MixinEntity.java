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

package me.asone.boatview360.mixins.piggyback;

import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = @Condition(value = "piggyback"))
@Mixin(Entity.class)
public abstract class MixinEntity {
	//#if MC >= 12000

	@Shadow
	public abstract boolean hasPassenger(Entity passenger);

	@Inject(
			method = "Lnet/minecraft/world/entity/Entity;positionRider(Lnet/minecraft/world/entity/Entity;)V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;positionRider(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity$MoveFunction;)V", shift = At.Shift.AFTER)
	)
	private void updatePassengerPositionAfter1(Entity passenger, CallbackInfo ci) {
		if (this.hasPassenger(passenger) && ((Object) this) instanceof Player player) {
			float bodyYaw = player.getVisualRotationYInDegrees();
			float f = Mth.wrapDegrees(passenger.yRotO - bodyYaw);
			float g = Mth.clamp(f, -105F, 105F);
			passenger.setYRot(passenger.yRotO);
			passenger.setYBodyRot(g == f ? bodyYaw : passenger.yRotO - g);
		}
	}
	//#endif

}
