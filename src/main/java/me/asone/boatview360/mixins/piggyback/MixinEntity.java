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
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
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
			method = "updatePassengerPosition(Lnet/minecraft/entity/Entity;)V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;updatePassengerPosition(Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity$PositionUpdater;)V", shift = At.Shift.AFTER)
	)
	private void updatePassengerPositionAfter1(Entity passenger, CallbackInfo ci) {
		if (this.hasPassenger(passenger) && ((Object) this) instanceof PlayerEntity player) {
			float bodyYaw = player.getBodyYaw();
			float f = MathHelper.wrapDegrees(passenger.prevYaw - bodyYaw);
			float g = MathHelper.clamp(f, -105F, 105F);
			passenger.setYaw(passenger.prevYaw);
			passenger.setBodyYaw(g == f ? bodyYaw : passenger.prevYaw - g);
		}
	}
	//#endif

}
