package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayerLookMove extends Player {
    
    public double x;
    public double y;
    public double stance;
    public double z;
    public float yaw;
    public float pitch;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readDouble();
        this.y = stream.readDouble();
        this.z = stream.readDouble();
        this.stance = stream.readDouble();
        this.yaw = stream.readFloat();
        this.pitch = stream.readFloat();
        super.read(stream);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeDouble(this.x);
        stream.writeDouble(this.y);
        stream.writeDouble(this.z);
        stream.writeDouble(this.stance);
        stream.writeFloat(this.yaw);
        stream.writeFloat(this.pitch);
        super.write(stream);
    }

    @Override
    public int length() {
        return 13;
    }

    @Override
    public byte getId() {
        return 13;
    }
}
