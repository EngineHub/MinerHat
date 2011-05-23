package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NamedEntitySpawn extends Packet {

    public int eid;
    public String name;
    public int x;
    public int y;
    public int z;
    public byte rotation;
    public byte pitch;
    public short currentItem;

    @Override
    public void read(DataInputStream datainputstream) throws IOException {
        this.eid = datainputstream.readInt();
        this.name = read(datainputstream, 16);
        this.x = datainputstream.readInt();
        this.y = datainputstream.readInt();
        this.z = datainputstream.readInt();
        this.rotation = datainputstream.readByte();
        this.pitch = datainputstream.readByte();
        this.currentItem = datainputstream.readShort();
    }

    @Override
    public void write(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.eid);
        //dataoutputstream.writeUTF(this.name);
        write(this.name, dataoutputstream);
        dataoutputstream.writeInt(this.x);
        dataoutputstream.writeInt(this.y);
        dataoutputstream.writeInt(this.z);
        dataoutputstream.writeByte(this.rotation);
        dataoutputstream.writeByte(this.pitch);
        dataoutputstream.writeShort(this.currentItem);
    }

    @Override
    public int length() {
        return 28;
    }

    @Override
    public byte getId() {
        return 20;
    }
}
