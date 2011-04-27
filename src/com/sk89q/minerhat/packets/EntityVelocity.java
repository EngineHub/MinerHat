package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EntityVelocity extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.a = stream.readInt();
        this.b = stream.readShort();
        this.c = stream.readShort();
        this.d = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.a);
        stream.writeShort(this.b);
        stream.writeShort(this.c);
        stream.writeShort(this.d);
    }

    @Override
    public int length() {
        return 10;
    }

    @Override
    public byte getId() {
        return 28;
    }
}
