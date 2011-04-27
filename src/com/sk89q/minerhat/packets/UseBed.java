package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UseBed extends Packet {

    public int id;
    public byte inBed;
    public int x;
    public byte y;
    public int z;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readInt();
        this.inBed = stream.readByte();
        this.x = stream.readInt();
        this.y = stream.readByte();
        this.z = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.id);
        stream.writeByte(this.inBed);
        stream.writeInt(this.x);
        stream.writeByte(this.y);
        stream.writeInt(this.z);
    }

    @Override
    public int length() {
        return 14;
    }

    @Override
    public byte getId() {
        return 17;
    }
}
