package com.matthewperiut.hotkettles;

import com.google.common.base.Suppliers;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.blockentity.HotKettleBlockEntities;
import com.matthewperiut.hotkettles.item.HotKettleItemGroups;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class HotKettles {
    public static final String MOD_ID = "hotkettles";
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static void init() {

        HotKettleBlocks.init();
        HotKettleItems.init();
        HotKettleBlockEntities.init();
        HotKettleItemGroups.init();
    }
}
