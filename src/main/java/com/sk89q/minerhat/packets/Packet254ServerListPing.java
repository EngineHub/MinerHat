package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.StreamHandler;

public class Packet254ServerListPing extends Packet {
    @Override
    public byte getId() {
        return (byte) 254;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {}

    @Override
    public void write(DataOutputStream stream) throws IOException {}

    @Override
    public int length() {
        return 0;
    }
}
