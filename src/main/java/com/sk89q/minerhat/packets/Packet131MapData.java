package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet131MapData extends Packet {

    public short a;
    public short b;
    public byte[] c;

    @Override
    public void read(DataInputStream stream) throws IOException {
      this.a = stream.readShort();
      this.b = stream.readShort();
      this.c = new byte[stream.readByte() & 0xFF];
      stream.readFully(this.c);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
      stream.writeShort(this.a);
      stream.writeShort(this.b);
      stream.writeByte(this.c.length);
      stream.write(this.c);
    }

    @Override
    public int length() {
      return 4 + this.c.length;
    }
    
    @Override
    public byte getId() {
        return (byte) 131;
    }
}
