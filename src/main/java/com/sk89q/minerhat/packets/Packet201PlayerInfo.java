package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet201PlayerInfo extends Packet {

    String playerName;
    boolean online;
    private short ping;

    @Override
    public byte getId() {
        return (byte) 201;
    }

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.playerName = read(stream, 16);
        this.online = stream.readByte() != 0;
        this.ping = stream.readShort();
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        write(this.playerName, stream);
        stream.writeByte(this.online ? 1 : 0);
        stream.writeShort(this.ping);
    }

    @Override
    public int length() {
        return 5 + this.playerName.length();
    }
}
