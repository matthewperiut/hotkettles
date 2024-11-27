package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.mixin.object.builder.client.ModelPredicateProviderRegistryAccessor;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.util.HotKettleComponents.HOT_DRINK_COMPONENT;

public class HotKettlesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HotKettlesClient.init();
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.kettle.get(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.empty_mug.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.apple_cider.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.bitter_water.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.cup_of_milk.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.poison.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.cup_of_water.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.cup_of_lava.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.hot_chocolate.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.latte.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.mocha.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.pumpkin_spice_latte.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.dandelion_tea.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.rose_tea.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.fairy_tea.get(), RenderLayer.getCutout());

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
