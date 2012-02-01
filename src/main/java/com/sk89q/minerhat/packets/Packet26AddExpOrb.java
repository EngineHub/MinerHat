package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet26AddExpOrb extends Packet {
    private int entityID;
    private int x;
    private int y;
    private short count;
    private int z;

    @Override
    public byte getId() {
        return 26;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.entityID = stream.readInt();
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.count = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.entityID);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.writeInt(this.count);
    }

    @Override
    public int length() {
        return 18;
    }
}
