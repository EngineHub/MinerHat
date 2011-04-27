package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class VehicleSpawn extends Packet {

    public int eid;
    public int x;
    public int y;
    public int z;
    public int type;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.type = stream.readByte();
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeByte(this.type);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
    }

    @Override
    public int length() {
        return 17;
    }

    @Override
    public byte getId() {
        return 23;
    }
}
