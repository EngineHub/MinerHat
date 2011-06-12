package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet39AttachEntity extends Packet {

    public int eid;
    public int vehicleId;

    public Packet39AttachEntity() {}

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.vehicleId = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeInt(this.vehicleId);
    }

    @Override
    public int length() {
        return 8;
    }

    @Override
    public byte getId() {
        return 39;
    }
}
