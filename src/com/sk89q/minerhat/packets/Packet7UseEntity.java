package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet7UseEntity extends Packet {

    public int user;
    public int target;
    public byte leftClick;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.user = stream.readInt();
        this.target = stream.readInt();
        this.leftClick = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.user);
        stream.writeInt(this.target);
        stream.writeByte(this.leftClick);
    }

    @Override
    public int length() {
        return 9;
    }

    @Override
    public byte getId() {
        return 7;
    }
}
