package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Handshake extends Packet {

    public String username;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.username = stream.readUTF();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeUTF(this.username);
    }

    @Override
    public int length() {
        return 4 + this.username.length() + 4;
    }

    @Override
    public byte getId() {
        return 2;
    }
}
