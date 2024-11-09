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
    public static RegistrySupplier<Block> empty_mug = BLOCKS.register(new Identifier(MOD_ID, "empty_mug"), () -> new MugBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));
    public static RegistrySupplier<Block> kettle = BLOCKS.register(new Identifier(MOD_ID, "kettle"), () -> new KettleBlock(AbstractBlock.Settings.create().strength(0.5F).resistance(0.5F)));

    public static void init() {

    }
}
