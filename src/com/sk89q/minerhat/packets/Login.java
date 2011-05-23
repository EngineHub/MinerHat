package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Login extends Packet {

    public int version;
    public String username;
    public long mapSeed;
    public byte dimension;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.version = stream.readInt();
        //this.username = stream.readUTF();
        this.username = read(stream, 16);
        this.mapSeed = stream.readLong();
        this.dimension = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.version);
        //stream.writeUTF(this.username);
        write(this.username, stream);
        stream.writeLong(this.mapSeed);
        stream.writeByte(this.dimension);
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
