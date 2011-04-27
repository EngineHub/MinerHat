package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HeldSlotChange extends Packet {

    public int slot;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.slot = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeShort(this.slot);
    }

    @Override
    public int length() {
        return 2;
    }

    @Override
    public byte getId() {
        return 16;
    }
}
