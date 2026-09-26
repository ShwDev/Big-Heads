// src/client/java/com/shaw/bigheads/client/mixin/AvatarRenderStateMixin.java
package com.shaw.bigheads.client.mixin;

import com.shaw.bigheads.client.HeadScaleAccessor;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AvatarRenderState.class)
public class AvatarRenderStateMixin implements HeadScaleAccessor {

    @Unique
    private float bigheads$headScale = 1.0F;

    @Override
    public float bigheads$getHeadScale() {
        return this.bigheads$headScale;
    }

    @Override
    public void bigheads$setHeadScale(float scale) {
        this.bigheads$headScale = scale;
    }
}