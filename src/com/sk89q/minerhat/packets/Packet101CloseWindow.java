package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet101CloseWindow extends Packet {

    public byte id;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public byte getId() {
        return 101;
    }
}
