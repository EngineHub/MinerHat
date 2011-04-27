package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PreChunk extends Packet {

    public int x;
    public int y;
    public boolean initialize;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.initialize = stream.read() != 0;
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.write(this.initialize ? 1 : 0);
    }

    @Override
    public int length() {
        return 9;
    }

    @Override
    public byte getId() {
        return 50;
    }
}
