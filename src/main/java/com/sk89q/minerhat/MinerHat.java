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
 * You should have received entityID copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.minerhat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jline.ConsoleReader;

public class MinerHat {

    private static final Logger logger = Logger.getLogger(MinerHat.class.getName());

    public static void main(String[] args) throws IOException {
        System.out.println("MinerHat (c) Copyright 2011 sk89q <http://www.sk89q.com>");
        System.out.println("All rights reserved.");
        System.out.println();

        Logger rootLogger = Logger.getLogger("");
        Formatter formatter = new SimpleLoggerFormatter();
        for (Handler handler : rootLogger.getHandlers()) {
            handler.setFormatter(formatter);
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        MinecraftProxyServer server = null;

        try {
            server = new MinecraftProxyServer(1111, InetAddress.getLocalHost(), 25565);
        } catch (UnknownHostException ex) {
            logger.severe("Failed to resolve localhost");
            System.exit(1);
            return;
        }

        (new Thread(server)).start();

        ConsoleReader reader = new ConsoleReader();
        String line;

        while ((line = reader.readLine("> ")) != null) {
            String[] parts = line.split(" ");
            if (parts[0].equalsIgnoreCase("host")) {
                if (parts.length == 2) {
                    try {
                        server.setTargetHost(InetAddress.getByName(parts[1]));
                        System.out.println("Host set to " + parts[1]);
                    } catch (IOException e) {
                        System.out.println("Could not resolve host " + parts[1]);
                    }
                } else {
                    System.out.println("host <host>");
                }
            } else if (parts[0].equalsIgnoreCase("port")) {
                if (parts.length == 2) {
                    try {
                        server.setTargetPort(Integer.parseInt(parts[1]));
                        System.out.println("Port set to " + parts[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid number: " + parts[1]);
                    }
                } else {
                    System.out.println("port <port>");
                }
            } else if (parts[0].equalsIgnoreCase("quit")) {
                System.exit(0);
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}
