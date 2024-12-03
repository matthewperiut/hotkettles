package com.matthewperiut.hotkettles.neoforge;

import com.matthewperiut.hotkettles.HotKettlesClient;
import com.matthewperiut.hotkettles.block.HotKettleBlocks;
import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import com.matthewperiut.hotkettles.client.render.blockentity.KettleBlockEntityRenderer;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
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
            // The block entity type, created using a builder.
            () -> BlockEntityType.Builder.create(
                            KettleBlockEntity::new,
                            HotKettleBlocks.KETTLE.get()
                    )
                    // Build using null; vanilla does some datafixer shenanigans with the parameter that we don't need.
                    .build(null)
    );

    public HotKettlesNeoForge(IEventBus modEventBus) {
        HotKettles.init();
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }

    @EventBusSubscriber(modid = HotKettles.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(KETTLE_BLOCK_ENTITY_TYPE.get(), KettleBlockEntityRenderer::new);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            HotKettlesClient.init();
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.KETTLE.get());

            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.EMPTY_MUG.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.APPLE_CIDER.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.BITTER_WATER.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.CUP_OF_MILK.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.POISON.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.CUP_OF_WATER.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.CUP_OF_LAVA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.HOT_CHOCOLATE.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.LATTE.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.MOCHA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.PUMPKIN_SPICE_LATTE.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.DANDELION_TEA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.ROSE_TEA.get());
            RenderTypeRegistry.register(RenderLayer.getCutout(), HotKettleBlocks.FAIRY_TEA.get());
        }
    }
}
