package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet250PluginMessage extends Packet {

    public String tag;
    public short length;
    public byte[] data;

    @Override
    public byte getId() {
        return (byte) 250;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.tag = read(stream, 16);
        this.length = stream.readShort();
        if (this.length > 0 && this.length < 32767) {
            this.data = new byte[this.length];
            stream.read(this.data);
        }
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        write(this.tag, stream);
        stream.writeShort(this.length);
        if (this.data != null) {
            stream.write(this.data);
        }
    }

    @Override
    public int length() {
        return 4 + this.tag.length() * 2 + this.length;
    }
}
