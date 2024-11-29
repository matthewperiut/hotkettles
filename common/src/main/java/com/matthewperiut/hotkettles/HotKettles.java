package com.matthewperiut.hotkettles;

import com.google.common.base.Suppliers;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.blockentity.HotKettleBlockEntities;
import com.matthewperiut.hotkettles.edible.HotKettleFoodComponents;
import com.matthewperiut.hotkettles.edible.HotKettlesConsumableComponents;
import com.matthewperiut.hotkettles.item.HotKettleItemGroups;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import com.matthewperiut.hotkettles.util.HotKettleComponents;
import dev.architectury.registry.registries.RegistrarManager;

import java.util.function.Supplier;

public class HotKettles {
    public static final String MOD_ID = "hotkettles";
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static boolean hot_workaround;

    public static void init() {
        HotKettlesConsumableComponents.init();
        HotKettleComponents.init();
        HotKettleBlocks.init();
        HotKettleItems.init();
        HotKettleFoodComponents.init();
        HotKettleBlockEntities.init();
        HotKettleItemGroups.init();
    }
}
