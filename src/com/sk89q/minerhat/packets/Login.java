package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Login extends Packet {

    public int version;
    public String username;
    public String password;
    public long mapSeed;
    public byte dimension;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.version = stream.readInt();
        this.username = stream.readUTF();
        this.password = stream.readUTF();
        this.mapSeed = stream.readLong();
        this.dimension = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.version);
        stream.writeUTF(this.username);
        stream.writeUTF(this.password);
        stream.writeLong(this.mapSeed);
        stream.writeByte(this.dimension);
    }

    @Override
    public int length() {
        return 4 + this.username.length() + this.password.length() + 4 + 5;
    }

    @Override
    public byte getId() {
        return 1;
    }
}
