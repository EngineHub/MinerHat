package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UpdateTime extends Packet {

    public long time;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.time = stream.readLong();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeLong(this.time);
    }

    @Override
    public int length() {
        return 8;
    }

    @Override
    public byte getId() {
        return 4;
    }
}
