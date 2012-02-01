package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn extends Packet {

    public int eid;
    public int x;
    public int y;
    public int z;
    public int type;
    // Need proper names once updated.
    public int projectileThrowerId;
    public short speedX;
    public short speedY;
    public short speedZ;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.type = stream.readByte();
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.projectileThrowerId = stream.readInt();
        if (this.projectileThrowerId > 0) {
          this.speedX = stream.readShort();
          this.speedY = stream.readShort();
          this.speedZ = stream.readShort();
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeByte(this.type);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.writeInt(this.projectileThrowerId);
        if (this.projectileThrowerId > 0) {
          stream.writeShort(this.speedX);
          stream.writeShort(this.speedY);
          stream.writeShort(this.speedZ);
        }
    }

    @Override
    public int length() {
        return 21 + this.projectileThrowerId > 0 ? 6 : 0;
    }

    @Override
    public byte getId() {
        return 23;
    }
}
