// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
 */

package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sk89q.minerhat.util.BlockPosition;
import com.sk89q.minerhat.util.ItemStack;

public class MetadataParser {
    public static List<MetadataObject> read(DataInputStream stream)
            throws IOException {
        
        ArrayList<MetadataObject> data = null;

        for (byte id = stream.readByte(); id != 127; id = stream.readByte()) {
            if (data == null) {
                data = new ArrayList<MetadataObject>();
            }

            MetadataObject entry = null;
            int type = (id & 0xE1) >> 5;
            int mask = id & 0x1F;

            switch (type) {
                case 0: // Byte
                    entry = new MetadataObject(type, mask,
                            Byte.valueOf(stream.readByte()));
                    break;
                case 1: // Short
                    entry = new MetadataObject(type, mask,
                            Short.valueOf(stream.readShort()));
                    break;
                case 2: // Integer
                    entry = new MetadataObject(type, mask,
                            Integer.valueOf(stream.readInt()));
                    break;
                case 3: // Float
                    entry = new MetadataObject(type, mask,
                            Float.valueOf(stream.readFloat()));
                    break;
                case 4: // String
                    entry = new MetadataObject(type, mask,
                            stream.readUTF());
                    break;
                case 5: // Item
                    short itemType = stream.readShort();
                    byte itemCount = stream.readByte();
                    short itemDamage = stream.readShort();
    
                    entry = new MetadataObject(type, mask,
                            new ItemStack(itemType, itemCount, itemDamage));
                case 6: // Position
                    int x = stream.readInt();
                    int y = stream.readInt();
                    int z = stream.readInt();
    
                    entry = new MetadataObject(type, mask,
                            new BlockPosition(x, y, z));

                default:
                    throw new UnsupportedOperationException("Unknown metadata type: " + type);
            }

            data.add(entry);
        }

        return data;
    }

    public static void write(List<MetadataObject> entries,
            DataOutputStream stream) throws IOException {
        
        if (entries == null) {
            stream.writeByte(127);
            return;
        }
        
        for (MetadataObject entry : entries) {
            write(entry, stream);
        }

        stream.writeByte(127);
    }

    public static void write(MetadataObject entry,
            DataOutputStream stream) throws IOException {
        
        int id = (entry.getType() << 5 | entry.getMask() & 0x1F) & 0xFF;
        stream.writeByte(id);
        
        switch (entry.getType()) {
            case 0:
                stream.writeByte((Byte) entry.getData());
                break;
            case 1:
                stream.writeShort((Short) entry.getData());
                break;
            case 2:
                stream.writeInt((Integer) entry.getData());
                break;
            case 3:
                stream.writeFloat((Float) entry.getData());
                break;
            case 4:
                stream.writeUTF((String) entry.getData());
                break;
            case 5:
                ItemStack itemstack = (ItemStack) entry.getData();
                stream.writeShort(itemstack.getId());
                stream.writeByte(itemstack.getCount());
                stream.writeShort(itemstack.getDamage());
            case 6:
                BlockPosition pos = (BlockPosition) entry.getData();
                stream.writeInt(pos.getX());
                stream.writeInt(pos.getY());
                stream.writeInt(pos.getZ());
            default:
                throw new UnsupportedOperationException("Unknown metadata type: " + entry.getType());
        }
    }

    public static class MetadataObject {

        private int type;
        private int mask;
        private Object data;

        public MetadataObject(int type, int mask, Object data) {
            this.type = type;
            this.mask = mask;
            this.data = data;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getMask() {
            return mask;
        }

        public void setMask(int mask) {
            this.mask = mask;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

    }
}
