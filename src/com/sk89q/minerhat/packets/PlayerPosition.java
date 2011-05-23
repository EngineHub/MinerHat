package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayerPosition extends Player {

    public double x;
    public double y;
    public double stance;
    public double z;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readDouble();
        this.y = stream.readDouble();
        this.stance = stream.readDouble();
        this.z = stream.readDouble();
        super.read(stream);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeDouble(this.x);
        stream.writeDouble(this.y);
        stream.writeDouble(this.stance);
        stream.writeDouble(this.z);
        super.write(stream);
    }

    @Override
    public int length() {
        return 33;
    }

    @Override
    public byte getId() {
        return 11;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append(" X: ");
        result.append(x);
        result.append(" Y: ");
        result.append(y);
        result.append(" Z: ");
        result.append(z);
        result.append(" Stance: ");
        result.append(stance);
        return result.toString();
    }
}
