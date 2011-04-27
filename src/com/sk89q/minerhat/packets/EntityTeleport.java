package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EntityTeleport extends Entity {

    public int x;
    public int y;
    public int z;
    public byte yaw;
    public byte pitch;

    @Override
    public void read(DataInputStream stream) throws IOException {
        super.read(stream);
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.yaw = (byte) stream.read();
        this.pitch = (byte) stream.read();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        super.write(stream);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.write(this.yaw);
        stream.write(this.pitch);
    }

    @Override
    public int length() {
        return 34;
    }

    @Override
    public byte getId() {
        return 34;
    }
}
