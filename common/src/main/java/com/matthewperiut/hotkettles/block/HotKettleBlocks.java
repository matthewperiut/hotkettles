package com.matthewperiut.hotkettles.block;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleBlocks {
    public static final Registrar<Block> BLOCKS = MANAGER.get().get(RegistryKeys.BLOCK);
    public static RegistrySupplier<Block> kettle = BLOCKS.register(Identifier.of(MOD_ID, "kettle"), () -> new KettleBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static RegistrySupplier<Block> empty_mug = BLOCKS.register(Identifier.of(MOD_ID, "empty_mug"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> apple_cider = BLOCKS.register(Identifier.of(MOD_ID, "apple_cider"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> bitter_water = BLOCKS.register(Identifier.of(MOD_ID, "bitter_water"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> cup_of_milk = BLOCKS.register(Identifier.of(MOD_ID, "cup_of_milk"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> poison = BLOCKS.register(Identifier.of(MOD_ID, "poison"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> cup_of_water = BLOCKS.register(Identifier.of(MOD_ID, "cup_of_water"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> cup_of_lava = BLOCKS.register(Identifier.of(MOD_ID, "cup_of_lava"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F).luminance((state) -> 12)));
    public static RegistrySupplier<Block> hot_chocolate = BLOCKS.register(Identifier.of(MOD_ID, "hot_chocolate"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> latte = BLOCKS.register(Identifier.of(MOD_ID, "latte"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> mocha = BLOCKS.register(Identifier.of(MOD_ID, "mocha"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> pumpkin_spice_latte = BLOCKS.register(Identifier.of(MOD_ID, "pumpkin_spice_latte"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> dandelion_tea = BLOCKS.register(Identifier.of(MOD_ID, "dandelion_tea"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> rose_tea = BLOCKS.register(Identifier.of(MOD_ID, "rose_tea"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> fairy_tea = BLOCKS.register(Identifier.of(MOD_ID, "fairy_tea"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static void init() {

    }
}
