package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HotKettlesFabric implements ModInitializer {
    public static final BlockEntityType<KettleBlockEntity> KETTLE_BLOCK_ENTITY_TYPE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(HotKettles.MOD_ID, "kettle"), FabricBlockEntityTypeBuilder.create(KettleBlockEntity::new, HotKettleBlocks.KETTLE.get()).build());

    @Override
    public void onInitialize() {
        HotKettles.init();
    }
}
