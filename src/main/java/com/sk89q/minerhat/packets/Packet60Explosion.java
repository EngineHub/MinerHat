package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sk89q.minerhat.util.BlockPosition;

public class Packet60Explosion extends Packet {

    public double x;
    public double y;
    public double z;
    public float radius;
    public List<BlockPosition> blocks = new ArrayList<BlockPosition>();

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readDouble();
        this.y = stream.readDouble();
        this.z = stream.readDouble();
        this.radius = stream.readFloat();
        int count = stream.readInt();

        this.blocks = new ArrayList<BlockPosition>();

        for (int i = 0; i < count; ++i) {
            int blockX = (int) (stream.readByte() + x);
            int blockY = (int) (stream.readByte() + y);
            int blockZ = (int) (stream.readByte() + z);

            this.blocks.add(new BlockPosition(blockX, blockY, blockZ));
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeDouble(this.x);
        stream.writeDouble(this.y);
        stream.writeDouble(this.z);
        stream.writeFloat(this.radius);
        stream.writeInt(this.blocks.size());
        
        for (BlockPosition pos : blocks) {
            stream.writeByte(pos.getX());
            stream.writeByte(pos.getY());
            stream.writeByte(pos.getZ());
        }
    }

    @Override
    public int length() {
        return 32 + this.blocks.size() * 3;
    }

    @Override
    public byte getId() {
        return 60;
    }
}
