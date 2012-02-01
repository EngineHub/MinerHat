package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet0KeepAlive extends Packet {

    public int keepAlive;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.keepAlive = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.keepAlive);
    }

    @Override
    public int length() {
        return 4;
    }

    @Override
    public byte getId() {
        return 0;
    }
}
