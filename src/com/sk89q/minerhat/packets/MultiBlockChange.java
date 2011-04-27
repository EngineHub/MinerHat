package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MultiBlockChange extends Packet {

    public int chunkX;
    public int chunkY;
    public short[] coordinateArray;
    public byte[] typeArray;
    public byte[] metadataArray;
    public int arraySize;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.chunkX = stream.readInt();
        this.chunkY = stream.readInt();
        this.arraySize = stream.readShort() & '\uffff';
        this.coordinateArray = new short[this.arraySize];
        this.typeArray = new byte[this.arraySize];
        this.metadataArray = new byte[this.arraySize];

        for (int i = 0; i < this.arraySize; ++i) {
            this.coordinateArray[i] = stream.readShort();
        }

        stream.readFully(this.typeArray);
        stream.readFully(this.metadataArray);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.chunkX);
        stream.writeInt(this.chunkY);
        stream.writeShort((short) this.arraySize);

        for (int i = 0; i < this.arraySize; ++i) {
            stream.writeShort(this.coordinateArray[i]);
        }

        stream.write(this.typeArray);
        stream.write(this.metadataArray);
    }

    @Override
    public int length() {
        return 10 + this.arraySize * 4;
    }

    @Override
    public byte getId() {
        return 52;
    }
}
