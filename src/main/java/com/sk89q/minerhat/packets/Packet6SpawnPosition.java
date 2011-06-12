package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SpawnPosition extends Packet {
    
    private int x;
    private int y;
    private int z;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
    }

    @Override
    public int length() {
        return 12;
    }

    @Override
    public byte getId() {
        return 6;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("X: ");
        result.append(x);
        result.append(" Y: ");
        result.append(y);
        result.append(" Z: ");
        result.append(z);
        return result.toString();
    }
}
