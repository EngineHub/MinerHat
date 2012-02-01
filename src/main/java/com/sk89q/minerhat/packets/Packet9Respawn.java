package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet9Respawn extends Packet {

    public byte dimension;
    public byte difficulty;
    public byte gameMode;
    public int height;
    public long seed;
    public String levelType;

    public Packet9Respawn() {}

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.dimension = stream.readByte();
        this.difficulty = stream.readByte();
        this.gameMode = stream.readByte();
        this.height = stream.readShort();
        this.seed = stream.readLong();
        this.levelType = read(stream, 16);

    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.dimension);
        stream.writeByte(this.difficulty);
        stream.writeByte(this.gameMode);
        stream.writeShort(this.height);
        stream.writeLong(this.seed);
        write(this.levelType, stream);
    }

    @Override
    public int length() {
        return 13 + this.levelType.length();
    }

    @Override
    public byte getId() {
        return 9;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append(" Dimension: ");
        result.append(dimension);
        result.append(" Type: ");
        result.append(this.levelType);
        return result.toString();
    }
}
