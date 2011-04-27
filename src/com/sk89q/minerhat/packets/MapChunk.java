package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MapChunk extends Packet {

    public int x;
    public int y;
    public int z;
    public int sizeX;
    public int sizeY;
    public int sizeZ;
    public byte[] rawData;
    private int compressedSize;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readShort();
        this.z = stream.readInt();
        this.sizeX = stream.read() + 1;
        this.sizeY = stream.read() + 1;
        this.sizeZ = stream.read() + 1;
        this.compressedSize = stream.readInt();
        rawData = new byte[this.compressedSize];
        stream.readFully(rawData);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.writeShort(this.y);
        stream.writeInt(this.z);
        stream.write(this.sizeX - 1);
        stream.write(this.sizeY - 1);
        stream.write(this.sizeZ - 1);
        stream.writeInt(this.compressedSize);
        stream.write(this.rawData, 0, this.compressedSize);
    }

    @Override
    public int length() {
        return 17 + this.compressedSize;
    }

    @Override
    public byte getId() {
        return 51;
    }
}
