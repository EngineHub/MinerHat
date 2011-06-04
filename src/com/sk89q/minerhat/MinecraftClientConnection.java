// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.minerhat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sk89q.minerhat.packets.Packet;
import com.sk89q.minerhat.packets.PacketManager;
import com.sk89q.minerhat.packets.PacketManager.UnknownPacketException;

class MinecraftClientConnection implements Runnable {

    private MinecraftProxyServerClient parent;
    private InetAddress host;
    private int port;
    private boolean running = true;
    private Socket sock;
    private DataOutputStream out;
    private DataInputStream in;
    private MinecraftProxyServerClient that;
    
    private static final Logger logger = Logger.getLogger(MinecraftProxyServerClient.class.getName());

    public MinecraftClientConnection(MinecraftProxyServerClient parent, InetAddress host, int port, MinecraftProxyServerClient minecraftProxyServerClient) {
        this.parent = parent;
        this.host = host;
        this.port = port;
        this.that = minecraftProxyServerClient;
    }

    public String getLoggerId() {
        return sock.getInetAddress().getHostAddress() + ":" + sock.getPort();
    }

    protected void log(Level level, final String msg) {
        logger.log(level, "(" + getLoggerId() + ") " + msg);
    }

    protected void log(Level level, final String msg, Throwable t) {
        logger.log(level, "(" + getLoggerId() + ") " + msg, t);
    }

    public void connect() throws IOException {
        sock = new Socket(host, port);
        sock.setTcpNoDelay(true); // Disable Nagle's algorithm's
        out = new DataOutputStream(sock.getOutputStream());
        in = new DataInputStream(sock.getInputStream());
    }

    public void run() {
        try {
            while (running) {
                byte id = in.readByte();
                Packet packet;

                try {
                    if(!(PacketManager.containsID(id))){
                        Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.SEVERE, "Packet " + id + " doesn't exist!");
                        continue;
                    }
                    packet = PacketManager.read(id, in);
                    // Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.INFO, "->" + packet.toString());
                    String name = packet.toString();
                    //if (!(name.contains("Entity")) && !(name.contains("Chunk")) && !(name.contains("PlayerPosition")) && !(name.contains("RelativeEntity"))) {
                        that.log(Level.INFO, "Server -> Client -> " + name);
                    //}
                } catch (UnknownPacketException ex) {
                    Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.SEVERE, null, ex);
                    sock.close();
                    break;
                }

                // log(Level.INFO, "->" + packet.toString());

                parent.handleIncoming(packet);
            }
        } catch (EOFException e) {
        } catch (IOException e) {
        }
    }

    public void send(Packet packet) throws IOException {
        out.write(packet.getId());
        packet.write(out);
        out.flush();
    }

    public void stop() {
        running = false;

        try {
            sock.close();
        } catch (IOException ex) {
        }
    }
}
