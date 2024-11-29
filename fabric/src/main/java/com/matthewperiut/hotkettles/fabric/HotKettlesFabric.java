package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

public class HotKettlesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        HotKettles.init();
        HotKettleBlockEntityTypes.init();
    }
}
