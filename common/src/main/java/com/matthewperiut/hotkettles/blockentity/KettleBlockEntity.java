package com.matthewperiut.hotkettles.blockentity;

import com.matthewperiut.hotkettles.block.KettleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KettleBlockEntity extends BlockEntity {
    public boolean dirX = false;
    public int liquidHorizontalOffset = 0;
    public int liquidLevel = 0;

    public KettleBlockEntity(BlockPos pos, BlockState state) {
        super(HotKettleBlockEntities.kettle_block_entity_type.get(), pos, state);
        Direction dir = state.get(Properties.HORIZONTAL_FACING);
        if (dir == Direction.EAST || dir == Direction.WEST) {
            dirX = true;
        }
        liquidHorizontalOffset = (state.get(KettleBlock.KETTLE_TYPE) * 2);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, KettleBlockEntity kettleBlockEntity) {
        // Your tick logic here
    }

    // Override the writeNbt method to save liquidLevel and liquidHorizontalOffset to NBT
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("LiquidLevel", this.liquidLevel);
        nbt.putInt("LiquidHorizontalOffset", this.liquidHorizontalOffset);
    }

    // Override the readNbt method to load liquidLevel and liquidHorizontalOffset from NBT
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.liquidLevel = nbt.getInt("LiquidLevel");
        this.liquidHorizontalOffset = nbt.getInt("LiquidHorizontalOffset");
    }

    // Override toInitialChunkDataNbt to send the initial data to the client
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    // Override toUpdatePacket to send updates to the client

    @Override
    public @Nullable net.minecraft.network.packet.Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    // Method to set the liquid level and notify the client
    public void setLiquidLevel(int level) {
        if (this.liquidLevel != level) {
            this.liquidLevel = level;
            markDirty();
            if (this.world != null) {
                this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), 3);
            }
        }
    }

    // Method to set the liquid horizontal offset and notify the client
    public void setLiquidHorizontalOffset(int offset) {
        if (this.liquidHorizontalOffset != offset) {
            this.liquidHorizontalOffset = offset;
            markDirty();
            if (this.world != null) {
                this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), 3);
            }
        }
    }
}
