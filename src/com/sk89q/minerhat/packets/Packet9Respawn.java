package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet9Respawn extends Packet {

    public byte dimension;
    
    public Packet9Respawn() {}

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.dimension = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.dimension);
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public byte getId() {
        return 9;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append(" Dimension: ");
        result.append(dimension);
        return result.toString();
    }
}
