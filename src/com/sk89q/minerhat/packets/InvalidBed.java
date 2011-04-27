package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InvalidBed extends Packet {

    public int b;

    public InvalidBed() {}

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.b = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.b);
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public byte getId() {
        return 70;
    }
}
