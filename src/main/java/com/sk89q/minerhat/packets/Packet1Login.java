package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet1Login extends Packet {

    public String username = "fernferret";
    public long mapSeed;
    public byte dimension;
    public int worldHeight;
    public byte difficulty;
    public byte maxPlayers;
    public int version;
    public String levelType;
    public int serverMode;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.version = stream.readInt();
        this.username = read(stream, 16);
        this.mapSeed = stream.readLong();
        this.levelType = read(stream, 16);
        this.serverMode = stream.readInt();
        this.dimension = stream.readByte();
        this.difficulty = stream.readByte();
        this.worldHeight = stream.readByte();
        this.maxPlayers = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.version);
        write(this.username, stream);
        stream.writeLong(this.mapSeed);
        write(this.levelType, stream);
        stream.writeInt(this.serverMode);
        stream.writeByte(this.dimension);
        stream.writeByte(this.difficulty);
        stream.writeByte(this.worldHeight);
        stream.writeByte(this.maxPlayers);
    }

    @Override
    public int length() {
        return 4 + this.username.length() + 4 + 5;
    }

    @Override
    public byte getId() {
        return 1;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("Username: ");
        result.append(username);
        result.append(" Version: ");
        result.append(version);
        result.append(" MapSeed: ");
        result.append(mapSeed);
        result.append(" Dimension: ");
        result.append(dimension);
        return result.toString();
    }
}
