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
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static com.matthewperiut.hotkettles.util.HotKettleComponents.HOT_DRINK_COMPONENT;

@Mod(HotKettles.MOD_ID)
public class HotKettlesNeoForge {
    public HotKettlesNeoForge(IEventBus modEventBus) {
        HotKettles.init();
    }

    @EventBusSubscriber(modid = HotKettles.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
                    if (itemStack.contains(HOT_DRINK_COMPONENT)) {
                        return 1.f;
                    }
                    return 0.f;
                });
            }
        }
    }
}
