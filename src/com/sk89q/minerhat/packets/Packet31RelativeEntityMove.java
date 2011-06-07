package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet31RelativeEntityMove extends Packet30Entity {

    public byte dx;
    public byte dy;
    public byte dz;

    @Override
    public void read(DataInputStream stream) throws IOException {
        super.read(stream);
        this.dx = stream.readByte();
        this.dy = stream.readByte();
        this.dz = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        super.write(stream);
        stream.writeByte(this.dx);
        stream.writeByte(this.dy);
        stream.writeByte(this.dz);
    }

    @Override
    public int length() {
        return 7;
    }

    @Override
    public byte getId() {
        return 31;
    }
}
