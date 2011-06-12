package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet2Handshake extends Packet {

    public String username;

    @Override
    public void read(DataInputStream stream) throws IOException {
        //this.username = stream.readUTF();
        this.username = read(stream, 32);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        //stream.writeUTF(this.username);
        write(this.username, stream);
    }

    @Override
    public int length() {
        return 4 + this.username.length() + 4;
    }

    @Override
    public byte getId() {
        return 2;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("String: ");
        result.append(username);
        return result.toString();
    }
}
