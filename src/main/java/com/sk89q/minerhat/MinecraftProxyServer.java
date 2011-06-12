// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
*/

package com.sk89q.minerhat;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sk89q
 */
public class MinecraftProxyServer implements Runnable {

    private static final Logger logger = Logger.getLogger(MinecraftProxyServer.class.getName());
    
    private int port;
    private InetAddress targetHost;
    private int targetPort;

    public MinecraftProxyServer(int port, InetAddress targetHost, int targetPort) {
        this.port = port;
        this.targetHost = targetHost;
        this.targetPort = targetPort;
    }

    public void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(getPort());

        logger.info("Ready for connections!");

        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            clientSocket.setTcpNoDelay(true); // Disable Nagle's algorithm's
            logger.info("Got connection from: " + clientSocket.toString());
            MinecraftProxyServerClient client = new MinecraftProxyServerClient(this, clientSocket);
            Thread thread = new Thread(client);
            thread.start();
        }
    }

    public int getPort() {
        return port;
    }

    public InetAddress getTargetHost() {
        return targetHost;
    }

    public int getTargetPort() {
        return targetPort;
    }

    public void setTargetHost(InetAddress targetHost) {
        this.targetHost = targetHost;
    }

    public void setTargetPort(int targetPort) {
        this.targetPort = targetPort;
    }

    public void run() {
        try {
            listen();
        } catch (IOException ex) {
            Logger.getLogger(MinecraftProxyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
