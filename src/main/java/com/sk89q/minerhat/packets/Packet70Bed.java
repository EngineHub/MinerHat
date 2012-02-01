package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet70Bed extends Packet {

    public int reasonCode;
    public int gameMode;


    public Packet70Bed() {}

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.reasonCode = stream.readByte();
        this.gameMode = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.reasonCode);
        stream.writeByte(this.gameMode);
    }

    @Override
    public int length() {
        return 2;
    }

    @Override
    public byte getId() {
        return 70;
    }
}
