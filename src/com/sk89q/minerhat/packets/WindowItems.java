package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.sk89q.minerhat.util.ItemStack;

public class WindowItems extends Packet {

    public byte id;
    public ItemStack[] items;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
        short count = stream.readShort();

        this.items = new ItemStack[count];

        for (int i = 0; i < count; ++i) {
            short short2 = stream.readShort();

            if (short2 >= 0) {
                byte b0 = stream.readByte();
                short short3 = stream.readShort();

                this.items[i] = new ItemStack(short2, b0, short3);
            }
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
        stream.writeShort(this.items.length);

        for (int i = 0; i < this.items.length; ++i) {
            if (this.items[i] == null) {
                stream.writeShort(-1);
            } else {
                stream.writeShort((short) this.items[i].getId());
                stream.writeByte((byte) this.items[i].getCount());
                stream.writeShort((short) this.items[i].getDamage());
            }
        }
    }

    @Override
    public int length() {
        return 3 + this.items.length * 5;
    }

    @Override
    public byte getId() {
        return 104;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append(" ID: ");
        result.append(id);
        result.append(" Items: ");
        result.append(items.toString());
        return result.toString();
    }
}
