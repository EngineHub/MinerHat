package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Player extends Packet {

    public boolean onGround;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.onGround = stream.read() != 0;
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.write(this.onGround ? 1 : 0);
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public byte getId() {
        return 10;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("OnGround: ");
        result.append(onGround);
        return result.toString();
    }
}
