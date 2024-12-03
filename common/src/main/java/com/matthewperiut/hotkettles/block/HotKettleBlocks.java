package com.matthewperiut.hotkettles.block;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleBlocks {
    public static final Registrar<Block> BLOCKS = MANAGER.get().get(RegistryKeys.BLOCK);

    public static final Identifier KETTLE_ID = Identifier.of(MOD_ID, "kettle");
    public static final RegistryKey<Block> KETTLE_KEY = RegistryKey.of(RegistryKeys.BLOCK, KETTLE_ID);
    public static final RegistrySupplier<Block> KETTLE = BLOCKS.register(KETTLE_ID, () -> new KettleBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));



    public static final Identifier EMPTY_MUG_ID = Identifier.of(MOD_ID, "empty_mug");
    public static final RegistryKey<Block> EMPTY_MUG_KEY = RegistryKey.of(RegistryKeys.BLOCK, EMPTY_MUG_ID);
    public static final RegistrySupplier<Block> EMPTY_MUG = BLOCKS.register(EMPTY_MUG_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier APPLE_CIDER_ID = Identifier.of(MOD_ID, "apple_cider");
    public static final RegistryKey<Block> APPLE_CIDER_KEY = RegistryKey.of(RegistryKeys.BLOCK, APPLE_CIDER_ID);
    public static final RegistrySupplier<Block> APPLE_CIDER = BLOCKS.register(APPLE_CIDER_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier BITTER_WATER_ID = Identifier.of(MOD_ID, "bitter_water");
    public static final RegistryKey<Block> BITTER_WATER_KEY = RegistryKey.of(RegistryKeys.BLOCK, BITTER_WATER_ID);
    public static final RegistrySupplier<Block> BITTER_WATER = BLOCKS.register(BITTER_WATER_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier CUP_OF_MILK_ID = Identifier.of(MOD_ID, "cup_of_milk");
    public static final RegistryKey<Block> CUP_OF_MILK_KEY = RegistryKey.of(RegistryKeys.BLOCK, CUP_OF_MILK_ID);
    public static final RegistrySupplier<Block> CUP_OF_MILK = BLOCKS.register(CUP_OF_MILK_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    // Continue the pattern of defining RegistryKeys and Identifiers
    public static final Identifier POISON_ID = Identifier.of(MOD_ID, "poison");
    public static final RegistryKey<Block> POISON_KEY = RegistryKey.of(RegistryKeys.BLOCK, POISON_ID);
    public static final RegistrySupplier<Block> POISON = BLOCKS.register(POISON_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier CUP_OF_WATER_ID = Identifier.of(MOD_ID, "cup_of_water");
    public static final RegistryKey<Block> CUP_OF_WATER_KEY = RegistryKey.of(RegistryKeys.BLOCK, CUP_OF_WATER_ID);
    public static final RegistrySupplier<Block> CUP_OF_WATER = BLOCKS.register(CUP_OF_WATER_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier CUP_OF_LAVA_ID = Identifier.of(MOD_ID, "cup_of_lava");
    public static final RegistryKey<Block> CUP_OF_LAVA_KEY = RegistryKey.of(RegistryKeys.BLOCK, CUP_OF_LAVA_ID);
    public static final RegistrySupplier<Block> CUP_OF_LAVA = BLOCKS.register(CUP_OF_LAVA_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F).luminance((state) -> 12)));

    public static final Identifier HOT_CHOCOLATE_ID = Identifier.of(MOD_ID, "hot_chocolate");
    public static final RegistryKey<Block> HOT_CHOCOLATE_KEY = RegistryKey.of(RegistryKeys.BLOCK, HOT_CHOCOLATE_ID);
    public static final RegistrySupplier<Block> HOT_CHOCOLATE = BLOCKS.register(HOT_CHOCOLATE_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier LATTE_ID = Identifier.of(MOD_ID, "latte");
    public static final RegistryKey<Block> LATTE_KEY = RegistryKey.of(RegistryKeys.BLOCK, LATTE_ID);
    public static final RegistrySupplier<Block> LATTE = BLOCKS.register(LATTE_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier MOCHA_ID = Identifier.of(MOD_ID, "mocha");
    public static final RegistryKey<Block> MOCHA_KEY = RegistryKey.of(RegistryKeys.BLOCK, MOCHA_ID);
    public static final RegistrySupplier<Block> MOCHA = BLOCKS.register(MOCHA_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier PUMPKIN_SPICE_LATTE_ID = Identifier.of(MOD_ID, "pumpkin_spice_latte");
    public static final RegistryKey<Block> PUMPKIN_SPICE_LATTE_KEY = RegistryKey.of(RegistryKeys.BLOCK, PUMPKIN_SPICE_LATTE_ID);
    public static final RegistrySupplier<Block> PUMPKIN_SPICE_LATTE = BLOCKS.register(PUMPKIN_SPICE_LATTE_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier DANDELION_TEA_ID = Identifier.of(MOD_ID, "dandelion_tea");
    public static final RegistryKey<Block> DANDELION_TEA_KEY = RegistryKey.of(RegistryKeys.BLOCK, DANDELION_TEA_ID);
    public static final RegistrySupplier<Block> DANDELION_TEA = BLOCKS.register(DANDELION_TEA_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier ROSE_TEA_ID = Identifier.of(MOD_ID, "rose_tea");
    public static final RegistryKey<Block> ROSE_TEA_KEY = RegistryKey.of(RegistryKeys.BLOCK, ROSE_TEA_ID);
    public static final RegistrySupplier<Block> ROSE_TEA = BLOCKS.register(ROSE_TEA_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static final Identifier FAIRY_TEA_ID = Identifier.of(MOD_ID, "fairy_tea");
    public static final RegistryKey<Block> FAIRY_TEA_KEY = RegistryKey.of(RegistryKeys.BLOCK, FAIRY_TEA_ID);
    public static final RegistrySupplier<Block> FAIRY_TEA = BLOCKS.register(FAIRY_TEA_ID, () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static void init() {

    }
}
