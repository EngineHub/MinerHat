package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet42RemoveEffect extends Packet {
    private int entityID;
    private byte effectID;

    @Override
    public byte getId() {
        return 42;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.entityID = stream.readInt();
        this.effectID = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.write(this.entityID);
        stream.write(this.effectID);
    }

    @Override
    public int length() {
        return 5;
    }
}
