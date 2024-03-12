package com.myname.DM_XHQ.entity.client;

import com.myname.DM_XHQ.TrierMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BeeSoldierModel extends AnimatedGeoModel {
    @Override
    public ResourceLocation getModelResource(Object object) {
        return new ResourceLocation(TrierMod.MODID, "geo/bee_soldier.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(Object object) {
        return new ResourceLocation(TrierMod.MODID, "textures/entity/bee_soldier_texture.png");

    }

    @Override
    public ResourceLocation getAnimationResource(Object animatable) {
        return new ResourceLocation(TrierMod.MODID, "animations/bee_soldier.animation.json");
    }
}
