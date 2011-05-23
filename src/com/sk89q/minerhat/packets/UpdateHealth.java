package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UpdateHealth extends Packet {

    public int health;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.health = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeShort(this.health);
    }

    @Override
    public int length() {
        return 2;
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
