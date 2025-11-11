package com.matthewperiut.hotkettles.neoforge;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(HotKettles.MOD_ID)
public class HotKettlesNeoForge {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, HotKettles.MOD_ID);

    public static final Supplier<BlockEntityType<KettleBlockEntity>> KETTLE_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(
            "kettle",
            () -> new BlockEntityType<>(
                    KettleBlockEntity::new,
                    HotKettleBlocks.KETTLE.get()
            )
    );

    public HotKettlesNeoForge(IEventBus modEventBus) {
        HotKettles.init();
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }
}
