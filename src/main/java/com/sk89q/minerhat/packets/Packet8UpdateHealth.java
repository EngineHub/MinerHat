package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet8UpdateHealth extends Packet {

    public int health;
    public int target;
    public float left;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.health = stream.readShort();
        this.target = stream.readShort();
        this.left = stream.readFloat();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeShort(this.health);
        stream.writeShort(this.target);
        stream.writeFloat(left);
    }

    @Override
    public int length() {
        return 8;
    }

    @Override
    public byte getId() {
        return 8;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("Health: ");
        result.append(health);
        return result.toString();
    }
}
