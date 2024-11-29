package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.edible.HotKettleFoodComponents;
import com.matthewperiut.hotkettles.edible.HotKettlesConsumableComponents;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;
import static com.matthewperiut.hotkettles.item.HotKettleItemGroups.*;

public class HotKettleItems {
    public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);

    // regular items below
    public static final Identifier CLAY_MUG_ID = Identifier.of(MOD_ID, "clay_mug");
    public static final RegistryKey<Item> CLAY_MUG_KEY = RegistryKey.of(RegistryKeys.ITEM, CLAY_MUG_ID);
    public static final RegistrySupplier<Item> CLAY_MUG = ITEMS.register(CLAY_MUG_ID, () -> new Item(new Item.Settings().arch$tab(KETTLE_TAB).registryKey(CLAY_MUG_KEY)));

    // block items below
    public static final Identifier EMPTY_MUG_ID = Identifier.of(MOD_ID, "empty_mug");
    public static final RegistryKey<Item> EMPTY_MUG_KEY = RegistryKey.of(RegistryKeys.ITEM, EMPTY_MUG_ID);
    public static final RegistrySupplier<Item> EMPTY_MUG = ITEMS.register(EMPTY_MUG_ID, () -> new EmptyMugItem(HotKettleBlocks.EMPTY_MUG.get(), new Item.Settings().arch$tab(KETTLE_TAB).registryKey(EMPTY_MUG_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier APPLE_CIDER_ID = Identifier.of(MOD_ID, "apple_cider");
    public static final RegistryKey<Item> APPLE_CIDER_KEY = RegistryKey.of(RegistryKeys.ITEM, APPLE_CIDER_ID);
    public static final RegistrySupplier<Item> APPLE_CIDER = ITEMS.register(APPLE_CIDER_ID, () -> new MugItem(HotKettleBlocks.APPLE_CIDER.get(), new Item.Settings().food(HotKettleFoodComponents.APPLE_CIDER, HotKettlesConsumableComponents.TEST_CONSUMABLE_COMPONENT).arch$tab(KETTLE_TAB).registryKey(APPLE_CIDER_KEY).useBlockPrefixedTranslationKey()));

    // continue block item pattern for the rest, all below will have .useBlockPrefixedTranslationKey
    public static final Identifier HOT_CIDER_ID = Identifier.of(MOD_ID, "hot_cider");
    public static final RegistryKey<Item> HOT_CIDER_KEY = RegistryKey.of(RegistryKeys.ITEM, HOT_CIDER_ID);
    public static final RegistrySupplier<Item> HOT_CIDER = ITEMS.register(HOT_CIDER_ID, () -> new MugItem(HotKettleBlocks.APPLE_CIDER.get(), new Item.Settings().food(HotKettleFoodComponents.HOT_CIDER).arch$tab(KETTLE_TAB).registryKey(HOT_CIDER_KEY).translationKey("block.hotkettles.apple_cider_hot")));

    public static final Identifier BITTER_WATER_ID = Identifier.of(MOD_ID, "bitter_water");
    public static final RegistryKey<Item> BITTER_WATER_KEY = RegistryKey.of(RegistryKeys.ITEM, BITTER_WATER_ID);
    public static final RegistrySupplier<Item> BITTER_WATER = ITEMS.register(BITTER_WATER_ID, () -> new MugItem(HotKettleBlocks.BITTER_WATER.get(), new Item.Settings().food(HotKettleFoodComponents.BITTER_WATER).arch$tab(KETTLE_TAB).registryKey(BITTER_WATER_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier HOT_COCOA_ID = Identifier.of(MOD_ID, "hot_cocoa");
    public static final RegistryKey<Item> HOT_COCOA_KEY = RegistryKey.of(RegistryKeys.ITEM, HOT_COCOA_ID);
    public static final RegistrySupplier<Item> HOT_COCOA = ITEMS.register(HOT_COCOA_ID, () -> new MugItem(HotKettleBlocks.BITTER_WATER.get(), new Item.Settings().food(HotKettleFoodComponents.HOT_COCOA).arch$tab(KETTLE_TAB).registryKey(HOT_COCOA_KEY).translationKey("block.hotkettles.bitter_water_hot")));

    public static final Identifier CUP_OF_MILK_ID = Identifier.of(MOD_ID, "cup_of_milk");
    public static final RegistryKey<Item> CUP_OF_MILK_KEY = RegistryKey.of(RegistryKeys.ITEM, CUP_OF_MILK_ID);
    public static final RegistrySupplier<Item> CUP_OF_MILK = ITEMS.register(CUP_OF_MILK_ID, () -> new MugItem(HotKettleBlocks.CUP_OF_MILK.get(), new Item.Settings().food(HotKettleFoodComponents.CUP_OF_MILK).arch$tab(KETTLE_TAB).registryKey(CUP_OF_MILK_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier STEAMED_MILK_ID = Identifier.of(MOD_ID, "steamed_milk");
    public static final RegistryKey<Item> STEAMED_MILK_KEY = RegistryKey.of(RegistryKeys.ITEM, STEAMED_MILK_ID);
    public static final RegistrySupplier<Item> STEAMED_MILK = ITEMS.register(STEAMED_MILK_ID, () -> new MugItem(HotKettleBlocks.CUP_OF_MILK.get(), new Item.Settings().food(HotKettleFoodComponents.STEAMED_MILK).arch$tab(KETTLE_TAB).registryKey(STEAMED_MILK_KEY).translationKey("block.hotkettles.cup_of_milk_hot")));

    public static final Identifier POISON_ID = Identifier.of(MOD_ID, "poison");
    public static final RegistryKey<Item> POISON_KEY = RegistryKey.of(RegistryKeys.ITEM, POISON_ID);
    public static final RegistrySupplier<Item> POISON = ITEMS.register(POISON_ID, () -> new MugItem(HotKettleBlocks.POISON.get(), new Item.Settings().food(HotKettleFoodComponents.POISON).arch$tab(KETTLE_TAB).registryKey(POISON_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier CUP_OF_WATER_ID = Identifier.of(MOD_ID, "cup_of_water");
    public static final RegistryKey<Item> CUP_OF_WATER_KEY = RegistryKey.of(RegistryKeys.ITEM, CUP_OF_WATER_ID);
    public static final RegistrySupplier<Item> CUP_OF_WATER = ITEMS.register(CUP_OF_WATER_ID, () -> new MugItem(HotKettleBlocks.CUP_OF_WATER.get(), new Item.Settings().food(HotKettleFoodComponents.CUP_OF_WATER).arch$tab(KETTLE_TAB).registryKey(CUP_OF_WATER_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier HOT_WATER_ID = Identifier.of(MOD_ID, "hot_water");
    public static final RegistryKey<Item> HOT_WATER_KEY = RegistryKey.of(RegistryKeys.ITEM, HOT_WATER_ID);
    public static final RegistrySupplier<Item> HOT_WATER = ITEMS.register(HOT_WATER_ID, () -> new MugItem(HotKettleBlocks.CUP_OF_WATER.get(), new Item.Settings().food(HotKettleFoodComponents.HOT_WATER).arch$tab(KETTLE_TAB).registryKey(HOT_WATER_KEY).translationKey("block.hotkettles.cup_of_water_hot")));

    public static final Identifier CUP_OF_LAVA_ID = Identifier.of(MOD_ID, "cup_of_lava");
    public static final RegistryKey<Item> CUP_OF_LAVA_KEY = RegistryKey.of(RegistryKeys.ITEM, CUP_OF_LAVA_ID);
    public static final RegistrySupplier<Item> CUP_OF_LAVA = ITEMS.register(CUP_OF_LAVA_ID, () -> new MugItem(HotKettleBlocks.CUP_OF_LAVA.get(), new Item.Settings().food(HotKettleFoodComponents.CUP_OF_LAVA).arch$tab(KETTLE_TAB).registryKey(CUP_OF_LAVA_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier HOT_CHOCOLATE_ID = Identifier.of(MOD_ID, "hot_chocolate");
    public static final RegistryKey<Item> HOT_CHOCOLATE_KEY = RegistryKey.of(RegistryKeys.ITEM, HOT_CHOCOLATE_ID);
    public static final RegistrySupplier<Item> HOT_CHOCOLATE = ITEMS.register(HOT_CHOCOLATE_ID, () -> new MugItem(HotKettleBlocks.HOT_CHOCOLATE.get(), new Item.Settings().food(HotKettleFoodComponents.HOT_CHOCOLATE).arch$tab(KETTLE_TAB).registryKey(HOT_CHOCOLATE_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier LATTE_ID = Identifier.of(MOD_ID, "latte");
    public static final RegistryKey<Item> LATTE_KEY = RegistryKey.of(RegistryKeys.ITEM, LATTE_ID);
    public static final RegistrySupplier<Item> LATTE = ITEMS.register(LATTE_ID, () -> new MugItem(HotKettleBlocks.LATTE.get(), new Item.Settings().food(HotKettleFoodComponents.LATTE).arch$tab(KETTLE_TAB).registryKey(LATTE_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier MOCHA_ID = Identifier.of(MOD_ID, "mocha");
    public static final RegistryKey<Item> MOCHA_KEY = RegistryKey.of(RegistryKeys.ITEM, MOCHA_ID);
    public static final RegistrySupplier<Item> MOCHA = ITEMS.register(MOCHA_ID, () -> new MugItem(HotKettleBlocks.MOCHA.get(), new Item.Settings().food(HotKettleFoodComponents.MOCHA).arch$tab(KETTLE_TAB).registryKey(MOCHA_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier PUMPKIN_SPICE_LATTE_ID = Identifier.of(MOD_ID, "pumpkin_spice_latte");
    public static final RegistryKey<Item> PUMPKIN_SPICE_LATTE_KEY = RegistryKey.of(RegistryKeys.ITEM, PUMPKIN_SPICE_LATTE_ID);
    public static final RegistrySupplier<Item> PUMPKIN_SPICE_LATTE = ITEMS.register(PUMPKIN_SPICE_LATTE_ID, () -> new MugItem(HotKettleBlocks.PUMPKIN_SPICE_LATTE.get(), new Item.Settings().food(HotKettleFoodComponents.PUMPKIN_SPICE_LATTE).arch$tab(KETTLE_TAB).registryKey(PUMPKIN_SPICE_LATTE_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier DANDELION_TEA_ID = Identifier.of(MOD_ID, "dandelion_tea");
    public static final RegistryKey<Item> DANDELION_TEA_KEY = RegistryKey.of(RegistryKeys.ITEM, DANDELION_TEA_ID);
    public static final RegistrySupplier<Item> DANDELION_TEA = ITEMS.register(DANDELION_TEA_ID, () -> new MugItem(HotKettleBlocks.DANDELION_TEA.get(), new Item.Settings().food(HotKettleFoodComponents.DANDELION_TEA).arch$tab(KETTLE_TAB).registryKey(DANDELION_TEA_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier ROSE_TEA_ID = Identifier.of(MOD_ID, "rose_tea");
    public static final RegistryKey<Item> ROSE_TEA_KEY = RegistryKey.of(RegistryKeys.ITEM, ROSE_TEA_ID);
    public static final RegistrySupplier<Item> ROSE_TEA = ITEMS.register(ROSE_TEA_ID, () -> new MugItem(HotKettleBlocks.ROSE_TEA.get(), new Item.Settings().food(HotKettleFoodComponents.ROSE_TEA).arch$tab(KETTLE_TAB).registryKey(ROSE_TEA_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier FAIRY_TEA_ID = Identifier.of(MOD_ID, "fairy_tea");
    public static final RegistryKey<Item> FAIRY_TEA_KEY = RegistryKey.of(RegistryKeys.ITEM, FAIRY_TEA_ID);
    public static final RegistrySupplier<Item> FAIRY_TEA = ITEMS.register(FAIRY_TEA_ID, () -> new MugItem(HotKettleBlocks.FAIRY_TEA.get(), new Item.Settings().food(HotKettleFoodComponents.FAIRY_TEA).arch$tab(KETTLE_TAB).registryKey(FAIRY_TEA_KEY).useBlockPrefixedTranslationKey()));

    public static final Identifier KETTLE_ID = Identifier.of(MOD_ID, "kettle");
    public static final RegistryKey<Item> KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, KETTLE_ID);
    public static final RegistrySupplier<Item> KETTLE = ITEMS.register(KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(KETTLE_KEY), 0));

    public static final Identifier POISON_KETTLE_ID = Identifier.of(MOD_ID, "poison_kettle");
    public static final RegistryKey<Item> POISON_KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, POISON_KETTLE_ID);
    public static final RegistrySupplier<Item> POISON_KETTLE = ITEMS.register(POISON_KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(POISON_KETTLE_KEY), 1));

    public static final Identifier WATER_KETTLE_ID = Identifier.of(MOD_ID, "water_kettle");
    public static final RegistryKey<Item> WATER_KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, WATER_KETTLE_ID);
    public static final RegistrySupplier<Item> WATER_KETTLE = ITEMS.register(WATER_KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(WATER_KETTLE_KEY), 2));

    public static final Identifier MILK_KETTLE_ID = Identifier.of(MOD_ID, "milk_kettle");
    public static final RegistryKey<Item> MILK_KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, MILK_KETTLE_ID);
    public static final RegistrySupplier<Item> MILK_KETTLE = ITEMS.register(MILK_KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(MILK_KETTLE_KEY), 3));

    public static final Identifier BITTER_KETTLE_ID = Identifier.of(MOD_ID, "bitter_kettle");
    public static final RegistryKey<Item> BITTER_KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, BITTER_KETTLE_ID);
    public static final RegistrySupplier<Item> BITTER_KETTLE = ITEMS.register(BITTER_KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(BITTER_KETTLE_KEY), 4));

    public static final Identifier APPLE_KETTLE_ID = Identifier.of(MOD_ID, "apple_kettle");
    public static final RegistryKey<Item> APPLE_KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, APPLE_KETTLE_ID);
    public static final RegistrySupplier<Item> APPLE_KETTLE = ITEMS.register(APPLE_KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(APPLE_KETTLE_KEY), 5));

    public static final Identifier LAVA_KETTLE_ID = Identifier.of(MOD_ID, "lava_kettle");
    public static final RegistryKey<Item> LAVA_KETTLE_KEY = RegistryKey.of(RegistryKeys.ITEM, LAVA_KETTLE_ID);
    public static final RegistrySupplier<Item> LAVA_KETTLE = ITEMS.register(LAVA_KETTLE_ID, () -> new KettleItem(HotKettleBlocks.KETTLE.get(), new KettleItem.Settings().arch$tab(KETTLE_TAB).registryKey(LAVA_KETTLE_KEY), 6));

    public static ArrayList<RegistrySupplier<Item>> kettles = new ArrayList<>();
    public static ArrayList<RegistrySupplier<Item>> heatableDrinks = new ArrayList<>();

    public static void init() {
        kettles.add(KETTLE);
        kettles.add(POISON_KETTLE);
        kettles.add(WATER_KETTLE);
        kettles.add(MILK_KETTLE);
        kettles.add(BITTER_KETTLE);
        kettles.add(APPLE_KETTLE);
        kettles.add(LAVA_KETTLE);

        heatableDrinks.add(APPLE_CIDER);
        heatableDrinks.add(BITTER_WATER);
        heatableDrinks.add(CUP_OF_MILK);
        heatableDrinks.add(CUP_OF_WATER);
    }
}
