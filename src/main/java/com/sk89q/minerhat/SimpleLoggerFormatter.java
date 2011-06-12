// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
*/

package com.sk89q.minerhat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

/**
 *
 * @author sk89q
 */
public class SimpleLoggerFormatter extends Formatter {
    private SimpleDateFormat dateFormatter =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord rec) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(dateFormatter.format(new Date()));
        buffer.append(" [");
        buffer.append(rec.getLevel().getName());
        buffer.append("] ");
        buffer.append(rec.getMessage());
        buffer.append("\r\n");
        Throwable throwable = rec.getThrown();
        if (throwable != null) {
            buffer.append(throwable.toString());
                buffer.append("\r\n");
            for (StackTraceElement element : throwable.getStackTrace()) {
                buffer.append("\t");
                buffer.append(element);
                buffer.append("\r\n");
            }
        }
        return buffer.toString();
    }
}
