package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Chat extends Packet {

    public String message;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.message = read(stream, 119);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        write(this.message, stream);
    }

    @Override
    public int length() {
        return this.message.length();
    }

    @Override
    public byte getId() {
        return 3;
    }
    
    public String toString(){
        return this.getClass().getName() + " -> " + message;
    }
}
