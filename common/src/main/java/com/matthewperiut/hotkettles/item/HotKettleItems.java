package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;
import static com.matthewperiut.hotkettles.item.HotKettleFoodComponents.*;
import static com.matthewperiut.hotkettles.item.HotKettleItemGroups.*;
import static com.matthewperiut.hotkettles.util.HotKettleComponents.HOT_DRINK_COMPONENT;
import static com.matthewperiut.hotkettles.util.HotKettleComponents.heatDrink;

public class HotKettleItems {
    public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);
    public static RegistrySupplier<Item> clay_mug            = ITEMS.register(new Identifier(MOD_ID, "clay_mug"), () -> new Item(new Item.Settings()));
    public static RegistrySupplier<Item> empty_mug           = ITEMS.register(new Identifier(MOD_ID, "empty_mug"), () -> new EmptyMugItem(HotKettleBlocks.empty_mug.get(), new Item.Settings()));
    public static RegistrySupplier<Item> apple_cider         = ITEMS.register(new Identifier(MOD_ID, "apple_cider"), () -> new MugItem(HotKettleBlocks.apple_cider.get(), new Item.Settings().food(APPLE_CIDER)));
    public static RegistrySupplier<Item> bitter_water        = ITEMS.register(new Identifier(MOD_ID, "bitter_water"), () -> new MugItem(HotKettleBlocks.bitter_water.get(), new Item.Settings().food(BITTER_WATER)));
    public static RegistrySupplier<Item> cup_of_milk         = ITEMS.register(new Identifier(MOD_ID, "cup_of_milk"), () -> new MugItem(HotKettleBlocks.cup_of_milk.get(), new Item.Settings().food(CUP_OF_MILK)));
    public static RegistrySupplier<Item> poison              = ITEMS.register(new Identifier(MOD_ID, "poison"), () -> new MugItem(HotKettleBlocks.poison.get(), new Item.Settings().food(POISON)));
    public static RegistrySupplier<Item> cup_of_water        = ITEMS.register(new Identifier(MOD_ID, "cup_of_water"), () -> new MugItem(HotKettleBlocks.cup_of_water.get(), new Item.Settings().food(CUP_OF_WATER)));
    public static RegistrySupplier<Item> cup_of_lava         = ITEMS.register(new Identifier(MOD_ID, "cup_of_lava"), () -> new MugItem(HotKettleBlocks.cup_of_lava.get(), new Item.Settings().food(CUP_OF_LAVA)));
    public static RegistrySupplier<Item> hot_chocolate       = ITEMS.register(new Identifier(MOD_ID, "hot_chocolate"), () -> new MugItem(HotKettleBlocks.hot_chocolate.get(), new Item.Settings().food(HOT_CHOCOLATE)));
    public static RegistrySupplier<Item> latte               = ITEMS.register(new Identifier(MOD_ID, "latte"), () -> new MugItem(HotKettleBlocks.latte.get(), new Item.Settings().food(LATTE)));
    public static RegistrySupplier<Item> mocha               = ITEMS.register(new Identifier(MOD_ID, "mocha"), () -> new MugItem(HotKettleBlocks.mocha.get(), new Item.Settings().food(MOCHA)));
    public static RegistrySupplier<Item> pumpkin_spice_latte = ITEMS.register(new Identifier(MOD_ID, "pumpkin_spice_latte"), () -> new MugItem(HotKettleBlocks.pumpkin_spice_latte.get(), new Item.Settings().food(PUMPKIN_SPICE_LATTE)));
    public static RegistrySupplier<Item> dandelion_tea       = ITEMS.register(new Identifier(MOD_ID, "dandelion_tea"), () -> new MugItem(HotKettleBlocks.dandelion_tea.get(), new Item.Settings().food(DANDELION_TEA)));
    public static RegistrySupplier<Item> rose_tea            = ITEMS.register(new Identifier(MOD_ID, "rose_tea"), () -> new MugItem(HotKettleBlocks.rose_tea.get(), new Item.Settings().food(ROSE_TEA)));
    public static RegistrySupplier<Item> fairy_tea           = ITEMS.register(new Identifier(MOD_ID, "fairy_tea"), () -> new MugItem(HotKettleBlocks.fairy_tea.get(), new Item.Settings().food(FAIRY_TEA)));
    public static RegistrySupplier<Item> kettle              = ITEMS.register(new Identifier(MOD_ID, "kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 0));
    public static RegistrySupplier<Item> poison_kettle       = ITEMS.register(new Identifier(MOD_ID, "poison_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 1));
    public static RegistrySupplier<Item> water_kettle        = ITEMS.register(new Identifier(MOD_ID, "water_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 2));
    public static RegistrySupplier<Item> milk_kettle         = ITEMS.register(new Identifier(MOD_ID, "milk_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 3));
    public static RegistrySupplier<Item> bitter_kettle       = ITEMS.register(new Identifier(MOD_ID, "bitter_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 4));
    public static RegistrySupplier<Item> apple_kettle        = ITEMS.register(new Identifier(MOD_ID, "apple_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 5));
    public static RegistrySupplier<Item> lava_kettle         = ITEMS.register(new Identifier(MOD_ID, "lava_kettle"), () -> new KettleItem(HotKettleBlocks.kettle.get(), new KettleItem.Settings(), 6));

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

        CreativeTabRegistry.append(KETTLE_TAB, clay_mug.get());
        CreativeTabRegistry.append(KETTLE_TAB, empty_mug.get());
        CreativeTabRegistry.append(KETTLE_TAB, cup_of_water.get());
        ItemStack hot_water = new ItemStack(cup_of_water.get());
        hot_water.set(HOT_DRINK_COMPONENT, true);
        hot_water.set(DataComponentTypes.FOOD, heatDrink(hot_water));
        CreativeTabRegistry.appendStack(KETTLE_TAB, hot_water);
        CreativeTabRegistry.append(KETTLE_TAB, apple_cider.get());
        ItemStack hot_cider = new ItemStack(apple_cider.get());
        hot_cider.set(HOT_DRINK_COMPONENT, true);
        hot_cider.set(DataComponentTypes.FOOD, heatDrink(hot_cider));
        CreativeTabRegistry.appendStack(KETTLE_TAB, hot_cider);
        CreativeTabRegistry.append(KETTLE_TAB, bitter_water.get());
        ItemStack hot_cocoa = new ItemStack(bitter_water.get());
        hot_cocoa.set(HOT_DRINK_COMPONENT, true);
        hot_cocoa.set(DataComponentTypes.FOOD, heatDrink(hot_cocoa));
        CreativeTabRegistry.appendStack(KETTLE_TAB, hot_cocoa);
        CreativeTabRegistry.append(KETTLE_TAB, cup_of_milk.get());
        ItemStack steamed_milk = new ItemStack(cup_of_milk.get());
        steamed_milk.set(HOT_DRINK_COMPONENT, true);
        steamed_milk.set(DataComponentTypes.FOOD, heatDrink(steamed_milk));
        CreativeTabRegistry.appendStack(KETTLE_TAB, steamed_milk);

        CreativeTabRegistry.append(KETTLE_TAB, poison.get());
        CreativeTabRegistry.append(KETTLE_TAB, cup_of_lava.get());
        CreativeTabRegistry.append(KETTLE_TAB, hot_chocolate.get());
        CreativeTabRegistry.append(KETTLE_TAB, latte.get());
        CreativeTabRegistry.append(KETTLE_TAB, mocha.get());
        CreativeTabRegistry.append(KETTLE_TAB, pumpkin_spice_latte.get());
        CreativeTabRegistry.append(KETTLE_TAB, dandelion_tea.get());
        CreativeTabRegistry.append(KETTLE_TAB, rose_tea.get());
        CreativeTabRegistry.append(KETTLE_TAB, fairy_tea.get());
        CreativeTabRegistry.append(KETTLE_TAB, kettle.get());
        CreativeTabRegistry.append(KETTLE_TAB, poison_kettle.get());
        CreativeTabRegistry.append(KETTLE_TAB, water_kettle.get());
        CreativeTabRegistry.append(KETTLE_TAB, milk_kettle.get());
        CreativeTabRegistry.append(KETTLE_TAB, bitter_kettle.get());
        CreativeTabRegistry.append(KETTLE_TAB, apple_kettle.get());
        CreativeTabRegistry.append(KETTLE_TAB, lava_kettle.get());

    }
}
