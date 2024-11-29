package com.matthewperiut.hotkettles;

import com.matthewperiut.hotkettles.blockentity.HotKettleBlockEntities;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;

public class HotKettlesClient {
    public static void init() {
        BlockEntityRendererRegistry.register(HotKettleBlockEntities.KETTLE_BLOCK_ENTITY_TYPE, KettleBlockEntityRenderer::new);
    }
}
