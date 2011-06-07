package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet12PlayerLook extends Packet10Flying {

    public float yaw;
    public float pitch;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.yaw = stream.readFloat();
        this.pitch = stream.readFloat();
        super.read(stream);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeFloat(this.yaw);
        stream.writeFloat(this.pitch);
        super.write(stream);
    }

    @Override
    public int length() {
        return 9;
    }

    @Override
    public byte getId() {
        return 12;
    }
}
