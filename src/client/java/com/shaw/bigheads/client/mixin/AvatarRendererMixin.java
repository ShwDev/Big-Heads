package com.shaw.bigheads.client.mixin;

import com.shaw.bigheads.BigHeads;


import com.shaw.bigheads.client.HeadScaleAccessor;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;


@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin {

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void bigheads$injectHeadScale(Avatar entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
        Float scale = BigHeads.headScales.get(entity.getUUID());
        ((HeadScaleAccessor) state).bigheads$setHeadScale(scale != null ? scale : 1.0F);
    }
}