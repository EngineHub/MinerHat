package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SetSlot extends Packet {

    public byte id;
    public short slot;
    public short itemId;
    public byte itemCount;
    public short itemUses;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
        this.slot = stream.readShort();
        this.itemId = stream.readShort();

        if (itemId >= 0) {
            this.itemCount = stream.readByte();
            this.itemUses = stream.readShort();
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
        stream.writeShort(this.slot);
        stream.writeShort(this.itemId);
        if (itemId >= 0) {
            stream.writeByte(this.itemCount);
            stream.writeShort(this.itemUses);
        }
    }

    @Override
    public int length() {
        return 8;
    }

    @Override
    public byte getId() {
        return 103;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append(" ID: ");
        result.append(id);
        result.append(" Slot: ");
        result.append(slot);
        result.append(" ItemCount: ");
        result.append(itemCount);
        result.append(" ItemID: ");
        result.append(itemId);
        result.append(" ItemUses:");
        result.append(itemUses);
        return result.toString();
    }
}
