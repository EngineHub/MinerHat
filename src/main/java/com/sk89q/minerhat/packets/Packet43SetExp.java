package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet43SetExp extends Packet {
    private float xpBar;
    private short level;
    private short totalXP;


    @Override
    public byte getId() {
        return 43;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.xpBar = stream.readFloat();
        this.level = stream.readShort();
        this.totalXP = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeFloat(this.xpBar);
        stream.writeShort(this.level);
        stream.writeShort(this.totalXP);

    }

    @Override
    public int length() {
        return 4;
    }
}
