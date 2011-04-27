package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OpenWindow extends Packet {

    public byte id;
    public byte type;
    public String title;
    public byte slotCount;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
        this.type = stream.readByte();
        this.title = stream.readUTF();
        this.slotCount = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
        stream.writeByte(this.type);
        stream.writeUTF(this.title);
        stream.writeByte(this.slotCount);
    }

    @Override
    public int length() {
        return 3 + this.title.length();
    }

    @Override
    public byte getId() {
        return 100;
    }
}
