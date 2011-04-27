// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
*/

package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PacketManager {
    
    private static final Map<Byte, Class<? extends Packet>> packets =
            new HashMap<Byte, Class<? extends Packet>>();
    
    static {
        packets.put((byte) 0, KeepAlive.class);
        packets.put((byte) 1, Login.class);
        packets.put((byte) 2, Handshake.class);
        packets.put((byte) 3, Chat.class);
        packets.put((byte) 4, UpdateTime.class);
        packets.put((byte) 5, EntityEquipment.class);
        packets.put((byte) 6, SpawnPosition.class);
        packets.put((byte) 7, UseEntity.class);
        packets.put((byte) 8, UpdateHealth.class);
        packets.put((byte) 9, Respawn.class);
        packets.put((byte) 10, Player.class);
        packets.put((byte) 11, PlayerPosition.class);
        packets.put((byte) 12, PlayerLook.class);
        packets.put((byte) 13, PlayerLookMove.class);
        packets.put((byte) 14, BlockDig.class);
        packets.put((byte) 15, PlaceBlock.class);
        packets.put((byte) 16, HeldSlotChange.class);
        packets.put((byte) 17, UseBed.class);
        packets.put((byte) 18, Animation.class);
        packets.put((byte) 19, EntityAction.class);
        packets.put((byte) 20, NamedEntitySpawn.class);
        packets.put((byte) 21, PickupSpawn.class);
        packets.put((byte) 22, CollectItem.class);
        packets.put((byte) 23, VehicleSpawn.class);
        packets.put((byte) 24, MobSpawn.class);
        packets.put((byte) 25, EntityPainting.class);
        packets.put((byte) 27, Packet027.class);
        packets.put((byte) 28, EntityVelocity.class);
        packets.put((byte) 29, DestroyEntity.class);
        packets.put((byte) 30, Entity.class);
        packets.put((byte) 31, RelativeEntityMove.class);
        packets.put((byte) 32, EntityLook.class);
        packets.put((byte) 33, RelativeEntityMoveLook.class);
        packets.put((byte) 34, EntityTeleport.class);
        packets.put((byte) 38, EntityStatus.class);
        packets.put((byte) 39, AttachEntity.class);
        packets.put((byte) 40, EntityMetadata.class);
        packets.put((byte) 50, PreChunk.class);
        packets.put((byte) 51, MapChunk.class);
        packets.put((byte) 52, MultiBlockChange.class);
        packets.put((byte) 53, BlockChange.class);
        packets.put((byte) 54, PlayNoteBlock.class);
        packets.put((byte) 60, Explosion.class);
        packets.put((byte) 70, InvalidBed.class);
        packets.put((byte) 100, OpenWindow.class);
        packets.put((byte) 101, CloseWindow.class);
        packets.put((byte) 102, WindowClick.class);
        packets.put((byte) 103, SetSlot.class);
        packets.put((byte) 104, WindowItems.class);
        packets.put((byte) 105, CraftProgressBar.class);
        packets.put((byte) 106, Transaction.class);
        packets.put((byte) 130, UpdateSign.class);
        packets.put((byte) 255, KickDisconnect.class);
    }
    
    public static Class<? extends Packet> get(byte id) throws UnknownPacketException {
        Class<? extends Packet> cls = packets.get(id);
        if (cls == null) {
            throw new UnknownPacketException();
        }
        return cls;
    }
    
    public static Packet construct(byte id) throws UnknownPacketException {
        Class<? extends Packet> cls = get(id);
        Packet packet;
        try {
            packet = (Packet) cls.newInstance();
        } catch (InstantiationException e) {
            throw new UnknownPacketException(e);
        } catch (IllegalAccessException e) {
            throw new UnknownPacketException(e);
        }
        if (id != packet.getId()) {
            throw new RuntimeException("Packet ID does not match read ID for "
                    + packet.getClass().getCanonicalName() + "; packet says "
                    + packet.getId() + "; actual is " + id);
        }
        return packet;
    }
    
    public static Packet read(byte id, DataInputStream stream)
            throws UnknownPacketException, IOException {
        Packet packet = construct(id);
        packet.read(stream);
        return packet;
    }
    
    public static class UnknownPacketException extends Exception {
        private static final long serialVersionUID = -8815444824778417409L;
        
        public UnknownPacketException() {
            super();
        }
        
        public UnknownPacketException(Throwable t) {
            super(t);
        }
    }
    
}
