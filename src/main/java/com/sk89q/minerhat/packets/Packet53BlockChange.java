package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet53BlockChange extends Packet {

    public int x;
    public byte y;
    public int z;
    public byte type;
    public byte data;

    public Packet53BlockChange() {
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readByte();
        this.z = stream.readInt();
        this.type = stream.readByte();
        this.data = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.write(this.y);
        stream.writeInt(this.z);
        stream.write(this.type);
        stream.write(this.data);
    }

    @Override
    public int length() {
        return 11;
    }

    @Override
    public byte getId() {
        return 53;
    }
}
