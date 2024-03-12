package com.myname.DM_XHQ.event;


import com.myname.DM_XHQ.TrierMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrierMod.MODID,bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClient {

//    @SubscribeEvent
//    public static void clientSetup(final FMLClientSetupEvent event) {
//        GeoArmorRenderer.registerArmorRenderer(LegendArmorItem.class, LegendArmorRenderer::new);
//    }



//    @SubscribeEvent
//    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
//        GeoArmorRenderer.registerArmorRenderer(LegendArmorItem.class, LegendArmorRenderer::new);
//    }
}
