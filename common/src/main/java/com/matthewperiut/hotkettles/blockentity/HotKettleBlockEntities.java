package com.matthewperiut.hotkettles.blockentity;

import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.mixin.BlockEntityTypeAccessor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleBlockEntities {
//    public static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = MANAGER.get().get(Registries.BLOCK_ENTITY_TYPE);

    public static final BlockEntityType<KettleBlockEntity> KETTLE_BLOCK_ENTITY_TYPE = BlockEntityTypeAccessor.create(Identifier.of(MOD_ID, "kettle").toString(), KettleBlockEntity::new, HotKettleBlocks.KETTLE.get());

    public static void init() {

    }
}
