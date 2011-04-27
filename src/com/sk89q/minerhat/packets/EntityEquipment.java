package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EntityEquipment extends Packet {

    public int eid;
    public int slot;
    public int itemId;
    public int d;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.slot = stream.readShort();
        this.itemId = stream.readShort();
        this.d = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeShort(this.slot);
        stream.writeShort(this.itemId);
        stream.writeShort(this.d);
    }

    @Override
    public int length() {
        return 8;
    }

    @Override
    public byte getId() {
        return 5;
    }
}
