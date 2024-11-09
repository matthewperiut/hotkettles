package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class HotKettlesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HotKettlesClient.init();
        BlockRenderLayerMap.INSTANCE.putBlock(HotKettleBlocks.kettle.get(), RenderLayer.getCutout());
    }
}
