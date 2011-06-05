package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Statistic extends Packet {

    int id;
    byte amount;
    
    @Override
    public byte getId() {
        return (byte) 200;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.id = stream.readInt();
        this.amount = stream.readByte();        
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.id);
        stream.writeByte(this.amount);
    }

    @Override
    public int length() {
        return 6;
    }
}
