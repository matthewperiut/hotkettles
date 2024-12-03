package com.matthewperiut.hotkettles.forge;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import dev.architectury.platform.forge.EventBuses;
import com.matthewperiut.hotkettles.HotKettles;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HotKettles.MOD_ID)
public class HotKettlesForge {
    public HotKettlesForge() {
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
