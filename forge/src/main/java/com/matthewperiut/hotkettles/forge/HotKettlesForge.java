package com.matthewperiut.hotkettles.forge;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
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

            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.empty_mug.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.apple_cider.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.bitter_water.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.cup_of_milk.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.poison.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.cup_of_water.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.cup_of_lava.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.hot_chocolate.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.latte.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.mocha.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.pumpkin_spice_latte.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.dandelion_tea.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.rose_tea.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.fairy_tea.get());

            for (RegistrySupplier<Item> i : HotKettleItems.heatableDrinks) {
                ModelPredicateProviderRegistry.register(i.get(), new Identifier(HotKettles.MOD_ID, "hot"), (itemStack, clientWorld, livingEntity, seed) -> {
                    if (itemStack.hasNbt() && itemStack.getNbt().contains("hot")) {
                        return 1.f;
                    }
                    return 0.f;
                });
            }
        }
    }
}
