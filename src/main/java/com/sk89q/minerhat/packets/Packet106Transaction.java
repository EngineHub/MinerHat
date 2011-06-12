package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet106Transaction extends Packet {

    public int id;
    public short action;
    public boolean accepted;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
        this.action = stream.readShort();
        this.accepted = stream.readByte() != 0;
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
        stream.writeShort(this.action);
        stream.writeByte(this.accepted ? 1 : 0);
    }

    @Override
    public int length() {
        return 4;
    }

    @Override
    public byte getId() {
        return 106;
    }
}
