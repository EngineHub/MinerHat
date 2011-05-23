package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UpdateSign extends Packet {

    public int x;
    public short y;
    public int z;
    public String[] lines;

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("X: ");
        result.append(x);
        result.append(" Y: ");
        result.append(y);
        result.append(" Z: ");
        result.append(z);
        result.append(" Lines: ");
        result.append(lines.toString());
        return result.toString();
    }
    
    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readShort();
        this.z = stream.readInt();
        this.lines = new String[4];

        for (int i = 0; i < 4; ++i) {
            //this.lines[i] = stream.readUTF();
            this.lines[i] = read(stream, 15);
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.writeShort(this.y);
        stream.writeInt(this.z);

        for (int i = 0; i < 4; ++i) {
            //stream.writeUTF(this.lines[i]);
            write(this.lines[i], stream);
        }
    }

    @Override
    public int length() {
        int i = 0;

        for (int j = 0; j < 4; ++j) {
            i += this.lines[j].length();
        }

        return i;
    }

    @Override
    public byte getId() {
        return (byte) 130;
    }
}
