package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayNoteBlock extends Packet {

    public int x;
    public short y;
    public int z;
    public byte instrument;
    public byte pitch;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readInt();
        this.y = stream.readShort();
        this.z = stream.readInt();
        this.instrument = stream.readByte();
        this.pitch = stream.readByte();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.writeShort(this.y);
        stream.writeInt(this.z);
        stream.write(this.instrument);
        stream.write(this.pitch);
    }

    @Override
    public int length() {
        return 12;
    }

    @Override
    public byte getId() {
        return 54;
    }
}
