package com.matthewperiut.hotkettles.client.render.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;

@Environment(EnvType.CLIENT)
public class KettleBlockEntityRenderState extends BlockEntityRenderState {
    public int liquidHorizontalOffset;
    public int liquidLevel;
    public boolean dirX;

    public KettleBlockEntityRenderState() {
        super();
    }
}