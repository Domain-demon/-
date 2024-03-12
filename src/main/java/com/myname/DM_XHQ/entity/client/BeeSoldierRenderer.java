package com.myname.DM_XHQ.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.myname.DM_XHQ.TrierMod;
import com.myname.DM_XHQ.entity.mob.BeeSoldier;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BeeSoldierRenderer extends GeoEntityRenderer<BeeSoldier> {

    public BeeSoldierRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BeeSoldierModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(BeeSoldier instance){
        return new ResourceLocation(TrierMod.MODID,"textures/entity/bee_soldier_texture.png");
    }

    @Override
    public RenderType getRenderType(BeeSoldier animatable, float partiaiTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partiaiTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
