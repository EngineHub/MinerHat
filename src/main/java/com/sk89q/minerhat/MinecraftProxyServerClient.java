// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
 */

package com.sk89q.minerhat;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import com.sk89q.minerhat.packets.Packet1Login;
import com.sk89q.minerhat.packets.Packet;
import com.sk89q.minerhat.packets.PacketManager;
import com.sk89q.minerhat.packets.PacketManager.UnknownPacketException;

/**
 * 
 * @author sk89q
 */
public class MinecraftProxyServerClient implements Runnable {

    public final Object outgoingLock = new Object();
    public final Object incomingLock = new Object();

    private static final Logger logger = Logger.getLogger(MinecraftProxyServerClient.class.getName());

    private boolean running = true;
    private MinecraftProxyFrame frame;
    private MinecraftProxyServer server;
    private Socket sock;
    private DataOutputStream out;
    private DataInputStream in;
    private MinecraftClientConnection client;

    public MinecraftProxyServerClient(MinecraftProxyServer server, Socket sock) throws IOException {
        this.server = server;
        this.sock = sock;

        out = new DataOutputStream(sock.getOutputStream());
        in = new DataInputStream(sock.getInputStream());
    }

    public MinecraftProxyServer getServer() {
        return server;
    }

    public String getLoggerId() {
        return sock.getInetAddress().getHostAddress() + ":" + sock.getPort();
    }

    protected void log(Level level, final String msg) {
        logger.log(level, "(" + getLoggerId() + ") " + msg);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.log(msg);
            }
        });
    }

    protected void log(Level level, final String msg, Throwable t) {
        logger.log(level, "(" + getLoggerId() + ") " + msg, t);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.log(msg);
            }
        });
    }

    public void run() {
        // Connect client
        client = new MinecraftClientConnection(this,server.getTargetHost(), server.getTargetPort(), this);
        
        frame = new MinecraftProxyFrame(this);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
                frame.setTitle("MinerHat: Minecraft proxy from " + getLoggerId());
            }
        });

        try {
            log(Level.INFO,"Establishing client connection to " + server.getTargetHost() + "...");
            client.connect();
            Thread thread = new Thread(client);
            thread.start();

            log(Level.INFO, "Client connection established!");

            while (running) {
                byte id = in.readByte();
                Packet packet;

                try {
                    if(!(PacketManager.containsID(id))){
                        Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.SEVERE, "--------------------------------");
                        Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.SEVERE, "Packet " + id + " doesn't exist!");
                        Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.SEVERE, "--------------------------------");
                        continue;
                    }
                    packet = PacketManager.read(id, in);
                    packet.toServer = true;
                } catch (UnknownPacketException ex) {
                    Logger.getLogger(MinecraftProxyServerClient.class.getName()).log(Level.SEVERE, null, ex);
                    sock.close();
                    break;
                }
                
                String name = packet.toString();
                log(Level.INFO, "Client -> Server -> " + name);
                
                try {
                    synchronized (outgoingLock) {
                        client.send(packet);
                    }
                } catch (IOException e) {
                    sock.close();
                    log(Level.INFO, "Client->server connection lost", e);
                }
            }
        } catch (EOFException ex) {
        } catch (IOException ex) {
        }

        client.stop();

        log(Level.INFO, "Proxy connection shutdown");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.handleEndedConnection();
            }
        });
    }

    public void send(Packet packet) throws IOException {
        synchronized (outgoingLock) {
            client.send(packet);
        }
    }

    public void receive(Packet packet) throws IOException {
        handleIncoming(packet);
    }

    public void handleIncoming(Packet packet) throws IOException {
        //log(Level.INFO, "<-" + packet.toString());

        if (packet instanceof Packet1Login) {
            final Packet1Login loginPacket = (Packet1Login) packet;

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    frame.addStatistic("World seed", String.valueOf(loginPacket.mapSeed));
                    frame.addStatistic("World dimension", String.valueOf(loginPacket.dimension));
                    frame.addStatistic("Protocol version", String.valueOf(loginPacket.version));
                }
            });
        }

        synchronized (incomingLock) {
            out.write(packet.getId());
            packet.write(out);
        }
    }

    public void stop() {
        running = false;

        try {
            sock.close();
        } catch (IOException ex) {
        }
    }
}
