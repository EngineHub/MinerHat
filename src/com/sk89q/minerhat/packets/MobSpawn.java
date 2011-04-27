package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import com.sk89q.minerhat.packets.MetadataParser.MetadataObject;

public class MobSpawn extends Packet {

    public int eid;
    public byte type;
    public int x;
    public int y;
    public int z;
    public byte yaw;
    public byte pitch;
    private List<MetadataObject> metadata;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.type = stream.readByte();
        this.x = stream.readInt();
        this.y = stream.readInt();
        this.z = stream.readInt();
        this.yaw = stream.readByte();
        this.pitch = stream.readByte();
        this.metadata = MetadataParser.read(stream);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        stream.writeByte(this.type);
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
        stream.writeByte(this.yaw);
        stream.writeByte(this.pitch);
        MetadataParser.write(metadata, stream);
    }

    @Override
    public int length() {
        return 20;
    }

    @Override
    public byte getId() {
        return 24;
    }
}
