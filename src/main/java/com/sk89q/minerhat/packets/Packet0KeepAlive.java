package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet0KeepAlive extends Packet {

    public Packet0KeepAlive() {}
    
    @Override
    public void read(DataInputStream stream) {}

    @Override
    public void write(DataOutputStream stream) {}

    @Override
    public int length() {
        return 0;
    }

    @Override
    public byte getId() {
        return 0;
    }
}
