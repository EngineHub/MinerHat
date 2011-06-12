// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
*/

package com.sk89q.minerhat.util;

public class BlockPosition {
    
    private int x;
    private int y;
    private int z;
    
    public BlockPosition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getZ() {
        return z;
    }
    
    public void setZ(int z) {
        this.z = z;
    }
    
}
