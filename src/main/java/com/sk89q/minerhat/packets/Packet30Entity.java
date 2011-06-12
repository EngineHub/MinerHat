package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet30Entity extends Packet {

    public int eid;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
    }

    @Override
    public int length() {
        return 4;
    }

    @Override
    public byte getId() {
        return 30;
    }
}
