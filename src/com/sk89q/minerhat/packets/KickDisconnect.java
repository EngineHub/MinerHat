package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class KickDisconnect extends Packet {

    public String message;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.message = stream.readUTF();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeUTF(this.message);
    }

    @Override
    public int length() {
        return this.message.length();
    }

    @Override
    public byte getId() {
        return (byte) 255;
    }
}
