package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet71Weather extends Packet {

    public int entityID;
    public byte unknown; // Always True from wiki. I have my doubts, investigate this!
    public int x;
    public int y;
    public int z;

   public void read(DataInputStream datainputstream) throws IOException {
        this.entityID = datainputstream.readInt();
        this.unknown = datainputstream.readByte();
        this.x = datainputstream.readInt();
        this.y = datainputstream.readInt();
        this.z = datainputstream.readInt();
    }

    public void write(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityID);
        dataoutputstream.writeByte(this.unknown);
        dataoutputstream.writeInt(this.x);
        dataoutputstream.writeInt(this.y);
        dataoutputstream.writeInt(this.z);
    }

    @Override
    public byte getId() {
        return 17;
    }

    @Override
    public int length() {
        return 0;
    }

}
