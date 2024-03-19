package com.myname.DM_XHQ.entity.client.renderer;

import com.myname.DM_XHQ.init.ModEntity;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ThrownBallRenderer {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

        event.registerEntityRenderer(ModEntity.THROWN_MANAMMO.get(), (p_174086_) -> new ThrownItemRenderer<>(p_174086_, 1.0F, true));

    }

}