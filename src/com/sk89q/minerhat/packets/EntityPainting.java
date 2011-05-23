package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EntityPainting extends Packet {

    public int eid;
    public int x;
    public int y;
    public int z;
    public int direction;
    public String title;

    public EntityPainting() {}

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        //this.title = stream.readUTF();
        this.title = read(stream, "SkullAndRoses".length());
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.direction = stream.readInt();
    }
    
    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        //stream.writeUTF(this.title);
        write(this.title,stream);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.writeInt(this.direction);
    }

    @Override
    public int length() {
        return 24;
    }

    @Override
    public byte getId() {
        return 25;
    }
}
