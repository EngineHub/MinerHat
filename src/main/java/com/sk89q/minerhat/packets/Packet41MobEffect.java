package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet41MobEffect extends Packet {
    private int entityID;
    private byte effectID;
    private byte amplifier;
    private short duration;

    @Override
    public byte getId() {
        return 41;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.entityID = stream.readInt();
        this.effectID = stream.readByte();
        this.amplifier = stream.readByte();
        this.duration = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.write(this.entityID);
        stream.write(this.effectID);
        stream.write(this.amplifier);
        stream.write(this.duration);
    }

    @Override
    public int length() {
        return 8;
    }
}
