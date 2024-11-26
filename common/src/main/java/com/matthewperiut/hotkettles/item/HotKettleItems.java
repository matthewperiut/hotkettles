package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleItems {
    public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);
    public static RegistrySupplier<Item> clay_mug            = ITEMS.register(new Identifier(MOD_ID, "clay_mug"), () -> new Item(new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> empty_mug           = ITEMS.register(new Identifier(MOD_ID, "empty_mug"), () -> new EmptyMugItem(HotKettleBlocks.empty_mug.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> apple_cider         = ITEMS.register(new Identifier(MOD_ID, "apple_cider"), () -> new MugItem(HotKettleBlocks.apple_cider.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> bitter_water        = ITEMS.register(new Identifier(MOD_ID, "bitter_water"), () -> new MugItem(HotKettleBlocks.bitter_water.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> cup_of_milk         = ITEMS.register(new Identifier(MOD_ID, "cup_of_milk"), () -> new MugItem(HotKettleBlocks.cup_of_milk.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> poison              = ITEMS.register(new Identifier(MOD_ID, "poison"), () -> new MugItem(HotKettleBlocks.poison.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> cup_of_water        = ITEMS.register(new Identifier(MOD_ID, "cup_of_water"), () -> new MugItem(HotKettleBlocks.cup_of_water.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> cup_of_lava         = ITEMS.register(new Identifier(MOD_ID, "cup_of_lava"), () -> new MugItem(HotKettleBlocks.cup_of_lava.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> hot_chocolate       = ITEMS.register(new Identifier(MOD_ID, "hot_chocolate"), () -> new MugItem(HotKettleBlocks.hot_chocolate.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> latte               = ITEMS.register(new Identifier(MOD_ID, "latte"), () -> new MugItem(HotKettleBlocks.latte.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> mocha               = ITEMS.register(new Identifier(MOD_ID, "mocha"), () -> new MugItem(HotKettleBlocks.mocha.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> pumpkin_spice_latte = ITEMS.register(new Identifier(MOD_ID, "pumpkin_spice_latte"), () -> new MugItem(HotKettleBlocks.pumpkin_spice_latte.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> dandelion_tea       = ITEMS.register(new Identifier(MOD_ID, "dandelion_tea"), () -> new MugItem(HotKettleBlocks.dandelion_tea.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> rose_tea            = ITEMS.register(new Identifier(MOD_ID, "rose_tea"), () -> new MugItem(HotKettleBlocks.rose_tea.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> fairy_tea           = ITEMS.register(new Identifier(MOD_ID, "fairy_tea"), () -> new MugItem(HotKettleBlocks.fairy_tea.get(), new Item.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB)));
    public static RegistrySupplier<Item> kettle              = ITEMS.register(new Identifier(MOD_ID, "kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 0));
    public static RegistrySupplier<Item> poison_kettle       = ITEMS.register(new Identifier(MOD_ID, "poison_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 1));
    public static RegistrySupplier<Item> water_kettle        = ITEMS.register(new Identifier(MOD_ID, "water_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 2));
    public static RegistrySupplier<Item> milk_kettle         = ITEMS.register(new Identifier(MOD_ID, "milk_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 3));
    public static RegistrySupplier<Item> bitter_kettle       = ITEMS.register(new Identifier(MOD_ID, "bitter_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 4));
    public static RegistrySupplier<Item> apple_kettle        = ITEMS.register(new Identifier(MOD_ID, "apple_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 5));
    public static RegistrySupplier<Item> lava_kettle         = ITEMS.register(new Identifier(MOD_ID, "lava_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings().arch$tab(HotKettleItemGroups.KETTLE_TAB), 6));

    public static ArrayList<RegistrySupplier<Item>> kettles = new ArrayList<>();
    public static ArrayList<RegistrySupplier<Item>> heatableDrinks = new ArrayList<>();

    public static void init() {
        kettles.add(kettle);
        kettles.add(poison_kettle);
        kettles.add(water_kettle);
        kettles.add(milk_kettle);
        kettles.add(bitter_kettle);
        kettles.add(apple_kettle);
        kettles.add(lava_kettle);

        heatableDrinks.add(apple_cider);
        heatableDrinks.add(bitter_water);
        heatableDrinks.add(cup_of_milk);
        heatableDrinks.add(cup_of_water);

        CreativeTabRegistry.modify(HotKettleItemGroups.KETTLE_TAB, (flags, output, canUseGameMasterBlocks) -> {
            ItemStack hot_cider = new ItemStack(apple_cider.get());
            hot_cider.getOrCreateNbt().putBoolean("hot", true);
            output.acceptAfter(apple_cider.get(), hot_cider);
            ItemStack hot_cocoa = new ItemStack(bitter_water.get());
            hot_cocoa.getOrCreateNbt().putBoolean("hot", true);
            output.acceptAfter(bitter_water.get(), hot_cocoa);
            ItemStack steamed_milk = new ItemStack(cup_of_milk.get());
            steamed_milk.getOrCreateNbt().putBoolean("hot", true);
            output.acceptAfter(cup_of_milk.get(), steamed_milk);
            ItemStack hot_water = new ItemStack(cup_of_water.get());
            hot_water.getOrCreateNbt().putBoolean("hot", true);
            output.acceptAfter(cup_of_water.get(), hot_water);
        });
    }
}
