package com.shaw.bigheads.client.mixin;

import com.shaw.bigheads.client.HeadScaleAccessor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends HumanoidRenderState> {

    @Shadow public ModelPart head;

    @Inject(method = "setupAnim", at = @At("TAIL"))
    private void bigheads$applyHeadScale(T state, CallbackInfo ci) {
        if (state instanceof HeadScaleAccessor accessor) {
            float scale = accessor.bigheads$getHeadScale();
            head.xScale = scale;
            head.yScale = scale;
            head.zScale = scale;
        }
    }
}