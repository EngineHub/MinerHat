package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.sk89q.minerhat.util.ItemStack;

public class PlaceBlock extends Packet {

    public int x;
    public byte y;
    public int z;
    public byte direction;
    public ItemStack item;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readByte();
        this.z = stream.readInt();
        this.direction = stream.readByte();
        short id = stream.readShort();

        if (id >= 0) {
            byte amount = stream.readByte();
            short damage = stream.readShort();

            this.item = new ItemStack(id, amount, damage);
        } else {
            this.item = null;
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.write(this.y);
        stream.writeInt(this.z);
        stream.write(this.direction);
        if (this.item == null) {
            stream.writeShort(-1);
        } else {
            stream.writeShort(this.item.getId());
            stream.writeByte(this.item.getCount());
            stream.writeShort(this.item.getDamage());
        }
    }

    @Override
    public int length() {
        return 15;
    }

    @Override
    public byte getId() {
        return 15;
    }
}
