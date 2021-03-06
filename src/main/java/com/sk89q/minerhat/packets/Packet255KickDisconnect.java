package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet255KickDisconnect extends Packet {

    public String message;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.message = read(stream, 100);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        //stream.writeUTF(this.message);
        write(this.message, stream);
    }

    @Override
    public int length() {
        return this.message.length();
    }

    @Override
    public byte getId() {
        return (byte) 255;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("Message: ");
        result.append(message);
        return result.toString();
    }
}
