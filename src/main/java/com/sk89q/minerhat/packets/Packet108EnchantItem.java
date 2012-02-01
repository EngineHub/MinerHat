package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet108EnchantItem extends Packet {

    public int windowID;
    public int enchantment;

    @Override
    public byte getId() {
        return (byte) 108;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.windowID = stream.readByte();
        this.enchantment = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.windowID);
        stream.writeByte(this.enchantment);
    }

    @Override
    public int length() {
        return 2;
    }
}
