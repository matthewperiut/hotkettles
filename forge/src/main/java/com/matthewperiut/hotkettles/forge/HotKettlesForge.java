package com.matthewperiut.hotkettles.forge;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import dev.architectury.platform.forge.EventBuses;
import com.matthewperiut.hotkettles.HotKettles;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HotKettles.MOD_ID)
public class HotKettlesForge {
    public HotKettlesForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(HotKettles.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        HotKettles.init();
    }

    @Mod.EventBusSubscriber(modid = HotKettles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            HotKettlesClient.init();
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.kettle.get());
        }
    }
}
