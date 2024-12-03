package com.matthewperiut.hotkettles.neoforge;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import com.matthewperiut.hotkettles.HotKettles;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(HotKettles.MOD_ID)
public class HotKettlesNeoForge {
    public HotKettlesNeoForge(IEventBus modEventBus) {
        HotKettles.init();
    }

    @Mod.EventBusSubscriber(modid = HotKettles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            HotKettlesClient.init();
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.KETTLE.get());

            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.EMPTY_MUG.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.APPLE_CIDER.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.BITTER_WATER.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.CUP_OF_MILK.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.POISON.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.CUP_OF_WATER.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.CUP_OF_LAVA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.HOT_CHOCOLATE.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.LATTE.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.MOCHA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.PUMPKIN_SPICE_LATTE.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.DANDELION_TEA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.ROSE_TEA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.FAIRY_TEA.get());
        }
    }
}
