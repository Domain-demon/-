package com.myname.DM_XHQ.entity.client;

import com.myname.DM_XHQ.TrierMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OrcModel extends AnimatedGeoModel {
    @Override
    public ResourceLocation getModelResource(Object object) {
        return new ResourceLocation(TrierMod.MODID, "geo/orc.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(Object object) {
        return new ResourceLocation(TrierMod.MODID, "textures/entity/orc_texture.png");

    }

    @Override
    public ResourceLocation getAnimationResource(Object animatable) {
        return new ResourceLocation(TrierMod.MODID, "animations/orc.animation.json");
    }
}
