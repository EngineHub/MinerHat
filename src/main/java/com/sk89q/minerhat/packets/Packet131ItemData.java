package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet131ItemData extends Packet {

    public short itemType;
    public short itemID;
    public byte[] textLength;

    @Override
    public void read(DataInputStream stream) throws IOException {
      this.itemType = stream.readShort();
      this.itemID = stream.readShort();
      this.textLength = new byte[stream.readByte() & 0xFF];
      stream.readFully(this.textLength);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
      stream.writeShort(this.itemType);
      stream.writeShort(this.itemID);
      stream.writeByte(this.textLength.length);
      stream.write(this.textLength);
    }

    @Override
    public int length() {
      return 4 + this.textLength.length;
    }

    @Override
    public byte getId() {
        return (byte) 131;
    }
}
