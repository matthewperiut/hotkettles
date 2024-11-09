package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleItems {
    public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);
    public static RegistrySupplier<Item> empty_mug = ITEMS.register(new Identifier(MOD_ID, "empty_mug"), () -> new BlockItem(HotKettleBlocks.empty_mug.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> kettle = ITEMS.register(new Identifier(MOD_ID, "kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 0));
    public static RegistrySupplier<Item> poison_kettle = ITEMS.register(new Identifier(MOD_ID, "poison_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 1));
    public static RegistrySupplier<Item> water_kettle = ITEMS.register(new Identifier(MOD_ID, "water_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 2));
    public static RegistrySupplier<Item> milk_kettle = ITEMS.register(new Identifier(MOD_ID, "milk_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 3));
    public static RegistrySupplier<Item> bitter_kettle = ITEMS.register(new Identifier(MOD_ID, "bitter_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 4));
    public static RegistrySupplier<Item> apple_kettle = ITEMS.register(new Identifier(MOD_ID, "apple_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 5));
    public static RegistrySupplier<Item> lava_kettle = ITEMS.register(new Identifier(MOD_ID, "lava_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 6));

    public static void init() {

    }
}
