package com.matthewperiut.hotkettles.neoforge;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static com.matthewperiut.hotkettles.neoforge.HotKettlesNeoForge.KETTLE_BLOCK_ENTITY_TYPE;

@EventBusSubscriber(modid = HotKettles.MOD_ID, value = Dist.CLIENT)
public class HotKettlesClientNeoForge {
    public HotKettlesClientNeoForge(ModContainer container) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        HotKettlesClient.init();
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(KETTLE_BLOCK_ENTITY_TYPE.get(), KettleBlockEntityRenderer::new);
    }
}