// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
*/

package com.sk89q.minerhat.util;

public class ItemStack {
    private int id;
    private int count;
    private int data;
    
    public ItemStack(int id, int count, int data) {
        this.id = id;
        this.count = count;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDamage() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
    public String toString(){
        return "ID: " + id + " Count: " + count + " Data: " + data;
    }
}
