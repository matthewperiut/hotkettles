package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import com.matthewperiut.hotkettles.mixin.BlockEntityTypeAccessor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

public class HotKettleBlockEntityTypes {
    public static final BlockEntityType<KettleBlockEntity> KETTLE_BLOCK_ENTITY_TYPE = BlockEntityTypeAccessor.create(Identifier.of(HotKettles.MOD_ID, "kettle").toString(), KettleBlockEntity::new, HotKettleBlocks.KETTLE.get());

    public static void init() {

    }
}
