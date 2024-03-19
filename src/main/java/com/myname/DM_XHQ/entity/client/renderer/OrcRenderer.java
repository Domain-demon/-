package com.myname.DM_XHQ.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.myname.DM_XHQ.TrierMod;
import com.myname.DM_XHQ.entity.client.model.OrcModel;
import com.myname.DM_XHQ.entity.mob.Orc;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OrcRenderer extends GeoEntityRenderer<Orc> {

    public OrcRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OrcModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(Orc instance){
        return new ResourceLocation(TrierMod.MODID,"textures/entity/orc_texture.png");
    }

    @Override
    public RenderType getRenderType(Orc animatable, float partiaiTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partiaiTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
