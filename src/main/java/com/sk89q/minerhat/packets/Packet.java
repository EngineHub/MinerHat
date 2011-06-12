package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Packet {
    public abstract byte getId();
    public abstract void read(DataInputStream datainputstream) throws IOException;
    public abstract void write(DataOutputStream dataoutputstream) throws IOException;
    public abstract int length();
    public boolean toServer;
    
    public static String read(DataInputStream datainputstream, int i) throws IOException {
        short short1 = datainputstream.readShort();

        if (short1 > i) {
            throw new IOException("Received string length longer than maximum allowed (" + short1 + " > " + i + ")");
        } else if (short1 < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        } else {
            StringBuilder stringbuilder = new StringBuilder();

            for (int j = 0; j < short1; ++j) {
                stringbuilder.append(datainputstream.readChar());
            }

            return stringbuilder.toString();
        }
    }
    
    public static void write(String s, DataOutputStream dataoutputstream) throws IOException {
        if (s.length() > 32767) {
            throw new IOException("String too big");
        } else {
            dataoutputstream.writeShort(s.length());
            dataoutputstream.writeChars(s);
        }
    }
}
