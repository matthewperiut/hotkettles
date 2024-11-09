package com.matthewperiut.hotkettles.blockentity;

import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleBlockEntities {
    public static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = MANAGER.get().get(Registries.BLOCK_ENTITY_TYPE);
    public static RegistrySupplier<BlockEntityType<KettleBlockEntity>> kettle_block_entity_type = BLOCK_ENTITY_TYPES.register(
            Identifier.of(MOD_ID, "kettle"),
            () -> BlockEntityType.Builder.create(KettleBlockEntity::new, HotKettleBlocks.kettle.get()).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, Identifier.of(MOD_ID, "kettle").toString()))
    );

    public static void init() {

    }
}
