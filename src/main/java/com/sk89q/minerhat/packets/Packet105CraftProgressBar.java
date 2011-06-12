package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet105CraftProgressBar extends Packet {

    public byte id;
    public short progress;
    public short value;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
        this.progress = stream.readShort();
        this.value = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
        stream.writeShort(this.progress);
        stream.writeShort(this.value);
    }

    @Override
    public int length() {
        return 5;
    }

    @Override
    public byte getId() {
        return 105;
    }
}
