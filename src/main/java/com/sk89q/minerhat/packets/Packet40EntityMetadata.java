package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import com.sk89q.minerhat.packets.MetadataParser.MetadataObject;

public class Packet40EntityMetadata extends Packet {

    public int eid;
    private List<MetadataObject> metadata;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.eid = stream.readInt();
        this.metadata = MetadataParser.read(stream);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.eid);
        MetadataParser.write(metadata, stream);
    }

    @Override
    public int length() {
        return 5;
    }

    @Override
    public byte getId() {
        return 40;
    }
}
