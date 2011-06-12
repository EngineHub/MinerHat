package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.sk89q.minerhat.util.ItemStack;

public class Packet21PickupSpawn extends Packet {

    public int eid;
    public int x;
    public int y;
    public int z;
    public byte rotation;
    public byte pitch;
    public byte roll;
    public ItemStack item;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.item = new ItemStack(stream.readShort(), stream.readByte(), stream.readShort());
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.rotation = stream.readByte();
        this.pitch = stream.readByte();
        this.roll = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeShort(this.item.getId());
        stream.writeByte(this.item.getCount());
        stream.writeShort(this.item.getDamage());
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.writeByte(this.rotation);
        stream.writeByte(this.pitch);
        stream.writeByte(this.roll);
    }

    @Override
    public int length() {
        return 24;
    }

    @Override
    public byte getId() {
        return 21;
    }
}
