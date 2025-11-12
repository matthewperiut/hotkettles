package com.matthewperiut.hotkettles.client.render.blockentity;

import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.BufferAllocator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class KettleBlockEntityRenderer implements BlockEntityRenderer<KettleBlockEntity, KettleBlockEntityRenderState> {
    // Custom texture identifier
    private static final Identifier LIQUIDS_TEXTURE = Identifier.of("hotkettles", "textures/blockentity/liquids.png");

    private static final float Z_FIGHT_OFFSET = 0.001F;

    public KettleBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public KettleBlockEntityRenderState createRenderState() {
        return new KettleBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(KettleBlockEntity kettleBlockEntity, KettleBlockEntityRenderState renderState, float tickDelta, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(kettleBlockEntity, renderState, tickDelta, cameraPos, crumblingOverlay);

        System.out.println(kettleBlockEntity.liquidLevel + " " + kettleBlockEntity.liquidHorizontalOffset);

        // Transfer data from block entity to render state
        renderState.liquidHorizontalOffset = kettleBlockEntity.liquidHorizontalOffset;
        renderState.liquidLevel = kettleBlockEntity.liquidLevel;
        renderState.dirX = kettleBlockEntity.dirX;
    }

    @Override
    public void render(KettleBlockEntityRenderState renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraRenderState) {
        // For now, we'll use immediate rendering as a fallback
        // In 1.21.10, custom quad rendering might need a different approach

        matrices.push();

        // Translate to the block's position
        matrices.translate(0, 1, 0);

        float uv_x_offset = renderState.liquidHorizontalOffset;
        int uv_y_offset = renderState.liquidLevel;

        float TEXTURE_WIDTH = 2;
        float TEXTURE_HEIGHT = 5;

        // Get immediate mode vertex consumer provider
        VertexConsumerProvider.Immediate immediate = VertexConsumerProvider.immediate(BufferAllocator.fixedSized(288));
        RenderLayer renderLayer = RenderLayer.getEntityCutout(LIQUIDS_TEXTURE);
        VertexConsumer vertexConsumer = immediate.getBuffer(renderLayer);

        // Render the liquid quads
        renderLiquidQuads(matrices, vertexConsumer, renderState, uv_x_offset, uv_y_offset, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        // Draw the buffer
        immediate.draw();

        matrices.pop();
    }

    private void renderLiquidQuads(MatrixStack matrices, VertexConsumer vertexConsumer, KettleBlockEntityRenderState renderState,
                                   float uv_x_offset, int uv_y_offset, float texWidth, float texHeight) {
        MatrixStack.Entry entry = matrices.peek();

        int light = renderState.lightmapCoordinates;
        int overlay = OverlayTexture.DEFAULT_UV;

        if (renderState.dirX) {
            // X-direction liquid faces - First face
            drawQuad(vertexConsumer, entry, light, overlay,
                    1 - (3 / 16.f) + Z_FIGHT_OFFSET, -(13 / 16.f), 0.4375F,
                    1 - (3 / 16.f) + Z_FIGHT_OFFSET, -(8 / 16.f), 0.4375F,
                    1 - (3 / 16.f) + Z_FIGHT_OFFSET, -(8 / 16.f), 0.5625F,
                    1 - (3 / 16.f) + Z_FIGHT_OFFSET, -(13 / 16.f), 0.5625F,
                    uv_x_offset / 64.F, (texHeight + uv_y_offset) / 32.F,
                    uv_x_offset / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, (texHeight + uv_y_offset) / 32.F
            );

            // X-direction liquid faces - Second face
            drawQuad(vertexConsumer, entry, light, overlay,
                    (3 / 16.f) - Z_FIGHT_OFFSET, -(13 / 16.f), 0.5625F,
                    (3 / 16.f) - Z_FIGHT_OFFSET, -(8 / 16.f), 0.5625F,
                    (3 / 16.f) - Z_FIGHT_OFFSET, -(8 / 16.f), 0.4375F,
                    (3 / 16.f) - Z_FIGHT_OFFSET, -(13 / 16.f), 0.4375F,
                    uv_x_offset / 64.F, (texHeight + uv_y_offset) / 32.F,
                    uv_x_offset / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, (texHeight + uv_y_offset) / 32.F
            );
        } else {
            // Z-direction liquid faces - First face
            drawQuad(vertexConsumer, entry, light, overlay,
                    0.4375F, -(13 / 16.f), (3 / 16.f) - Z_FIGHT_OFFSET,
                    0.4375F, -(8 / 16.f), (3 / 16.f) - Z_FIGHT_OFFSET,
                    0.5625F, -(8 / 16.f), (3 / 16.f) - Z_FIGHT_OFFSET,
                    0.5625F, -(13 / 16.f), (3 / 16.f) - Z_FIGHT_OFFSET,
                    uv_x_offset / 64.F, (texHeight + uv_y_offset) / 32.F,
                    uv_x_offset / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, (texHeight + uv_y_offset) / 32.F
            );

            // Z-direction liquid faces - Second face
            drawQuad(vertexConsumer, entry, light, overlay,
                    0.5625F, -(13 / 16.f), 1 - (3 / 16.f) + Z_FIGHT_OFFSET,
                    0.5625F, -(8 / 16.f), 1 - (3 / 16.f) + Z_FIGHT_OFFSET,
                    0.4375F, -(8 / 16.f), 1 - (3 / 16.f) + Z_FIGHT_OFFSET,
                    0.4375F, -(13 / 16.f), 1 - (3 / 16.f) + Z_FIGHT_OFFSET,
                    uv_x_offset / 64.F, (texHeight + uv_y_offset) / 32.F,
                    uv_x_offset / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, uv_y_offset / 32.F,
                    (texWidth + uv_x_offset) / 64.F, (texHeight + uv_y_offset) / 32.F
            );
        }
    }

    private void drawQuad(VertexConsumer vertexConsumer, MatrixStack.Entry entry,
                          int light, int overlay,
                          float x1, float y1, float z1,
                          float x2, float y2, float z2,
                          float x3, float y3, float z3,
                          float x4, float y4, float z4,
                          float u1, float v1,
                          float u2, float v2,
                          float u3, float v3,
                          float u4, float v4) {

        // Draw the quad vertices using the correct method signatures
        vertexConsumer.vertex(entry, x1, y1, z1)
                .color(255, 255, 255, 255)
                .texture(u1, v1)
                .overlay(overlay)
                .light(light)
                .normal(entry, 0.0f, 0.0f, 1.0f);

        vertexConsumer.vertex(entry, x2, y2, z2)
                .color(255, 255, 255, 255)
                .texture(u2, v2)
                .overlay(overlay)
                .light(light)
                .normal(entry, 0.0f, 0.0f, 1.0f);

        vertexConsumer.vertex(entry, x3, y3, z3)
                .color(255, 255, 255, 255)
                .texture(u3, v3)
                .overlay(overlay)
                .light(light)
                .normal(entry, 0.0f, 0.0f, 1.0f);

        vertexConsumer.vertex(entry, x4, y4, z4)
                .color(255, 255, 255, 255)
                .texture(u4, v4)
                .overlay(overlay)
                .light(light)
                .normal(entry, 0.0f, 0.0f, 1.0f);
    }
}