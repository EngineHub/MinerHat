package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Packet {
    public abstract byte getId();
    public abstract void read(DataInputStream datainputstream) throws IOException;
    public abstract void write(DataOutputStream dataoutputstream) throws IOException;
    public abstract int length();
}
