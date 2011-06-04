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
    // Need proper names once updated.
    public int i;
    public short e;
    public short f;
    public short g;    

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.type = stream.readByte();
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.i = stream.readInt();
        if (this.i > 0) {
          this.e = stream.readShort();
          this.f = stream.readShort();
          this.g = stream.readShort();
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeByte(this.type);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.writeInt(this.i);
        if (this.i > 0) {
          stream.writeShort(this.e);
          stream.writeShort(this.f);
          stream.writeShort(this.g);
        }
    }

    @Override
    public int length() {
        return 21 + this.i > 0 ? 6 : 0;
    }

    @Override
    public byte getId() {
        return 23;
    }
}
