package com.matthewperiut.hotkettles;

import com.matthewperiut.hotkettles.blockentity.HotKettleBlockEntities;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class HotKettlesClient {
    public static void init() {
        BlockEntityRendererRegistry.register(HotKettleBlockEntities.kettle_block_entity_type.get(), KettleBlockEntityRenderer::new);
    }
}
