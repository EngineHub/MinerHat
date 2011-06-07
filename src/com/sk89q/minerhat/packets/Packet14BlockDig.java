package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet14BlockDig extends Packet {

    public byte status;
    public int x;
    public byte y;
    public int z;
    public byte face;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.status = stream.readByte();
        this.x = stream.readInt();
        this.y = stream.readByte();
        this.z = stream.readInt();
        this.face = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.status);
        stream.writeInt(this.x);
        stream.writeByte(this.y);
        stream.writeInt(this.z);
        stream.writeByte(this.face);
    }

    @Override
    public int length() {
        return 11;
    }

    @Override
    public byte getId() {
        return 14;
    }
}
