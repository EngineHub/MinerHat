package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class Packet61WorldEvent extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    @Override
    public void read(DataInputStream stream) throws IOException {
      this.a = stream.readInt();
      this.c = stream.readInt();
      this.d = stream.readByte();
      this.e = stream.readInt();
      this.b = stream.readInt();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
      stream.writeInt(this.a);
      stream.writeInt(this.c);
      stream.writeByte(this.d);
      stream.writeInt(this.e);
      stream.writeInt(this.b);
    }

    @Override
    public int length() {
      return 20;
    }

    @Override
    public byte getId() {
        return 61;
    }
}
