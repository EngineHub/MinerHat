package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CollectItem extends Packet {

    public int collectedEID;
    public int collectorEID;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.collectedEID = stream.readInt();
        this.collectorEID = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.collectedEID);
        stream.writeInt(this.collectorEID);
    }

    @Override
    public int length() {
        return 8;
    }

    @Override
    public byte getId() {
        return 22;
    }
}
