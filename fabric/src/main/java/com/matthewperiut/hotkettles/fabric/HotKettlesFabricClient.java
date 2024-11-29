package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;


public class HotKettlesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HotKettlesClient.init();
        BlockEntityRendererRegistry.register(HotKettlesFabric.KETTLE_BLOCK_ENTITY_TYPE, KettleBlockEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.KETTLE.get(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.EMPTY_MUG.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.APPLE_CIDER.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.BITTER_WATER.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.CUP_OF_MILK.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.POISON.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.CUP_OF_WATER.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.CUP_OF_LAVA.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.HOT_CHOCOLATE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.LATTE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.MOCHA.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.PUMPKIN_SPICE_LATTE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.DANDELION_TEA.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.ROSE_TEA.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.FAIRY_TEA.get(), RenderLayer.getCutout());
    }
}
