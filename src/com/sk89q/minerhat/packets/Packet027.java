package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet027 extends Packet {

    private float a;
    private float b;
    private boolean c;
    private boolean d;
    private float e;
    private float f;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.a = stream.readFloat();
        this.b = stream.readFloat();
        this.e = stream.readFloat();
        this.f = stream.readFloat();
        this.c = stream.readBoolean();
        this.d = stream.readBoolean();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeFloat(this.a);
        stream.writeFloat(this.b);
        stream.writeFloat(this.e);
        stream.writeFloat(this.f);
        stream.writeBoolean(this.c);
        stream.writeBoolean(this.d);
    }

    @Override
    public int length() {
        return 18;
    }

    @Override
    public byte getId() {
        return 27;
    }
}
