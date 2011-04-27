package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Animation extends Packet {

    public int eid;
    public int animation;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.animation = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeByte(this.animation);
    }

    @Override
    public int length() {
        return 5;
    }

    @Override
    public byte getId() {
        return 18;
    }
}
