package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class WindowClick extends Packet {

    public byte id;
    public short slot;
    public byte rightClick;
    public short actionNum;
    public short itemId;
    public byte itemCount;
    public short itemUses;
    public boolean f;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readByte();
        this.slot = stream.readShort();
        this.rightClick = stream.readByte();
        this.actionNum = stream.readShort();
        this.f = stream.readBoolean();
        this.itemId = stream.readShort();
        
        if (itemId >= 0) {
            itemCount = stream.readByte();
            itemUses = stream.readShort();
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(this.id);
        stream.writeShort(this.slot);
        stream.writeByte(this.rightClick);
        stream.writeShort(this.actionNum);
        stream.writeBoolean(this.f);
        stream.writeShort(this.itemId);
        
        if (itemId >= 0) {
            stream.writeByte(itemCount);
            stream.writeShort(itemUses);
        }
    }

    @Override
    public int length() {
        return 11;
    }

    @Override
    public byte getId() {
        return 102;
    }
}
