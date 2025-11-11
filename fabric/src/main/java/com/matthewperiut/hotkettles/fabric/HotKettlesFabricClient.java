package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;


public class HotKettlesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HotKettlesClient.init();
        BlockEntityRendererRegistry.register(HotKettlesFabric.KETTLE_BLOCK_ENTITY_TYPE, KettleBlockEntityRenderer::new);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.KETTLE.get(), BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(HotKettleBlocks.EMPTY_MUG.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.APPLE_CIDER.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.BITTER_WATER.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.CUP_OF_MILK.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.POISON.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.CUP_OF_WATER.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.CUP_OF_LAVA.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.HOT_CHOCOLATE.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.LATTE.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.MOCHA.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.PUMPKIN_SPICE_LATTE.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.DANDELION_TEA.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.ROSE_TEA.get(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(HotKettleBlocks.FAIRY_TEA.get(), BlockRenderLayer.CUTOUT);
    }
}
