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

    private static final Map<Byte, Class<? extends Packet>> packets = new HashMap<Byte, Class<? extends Packet>>();

    static {
        packets.put((byte) 0, Packet0KeepAlive.class);
        packets.put((byte) 1, Packet1Login.class);
        packets.put((byte) 2, Packet2Handshake.class);
        packets.put((byte) 3, Packet3Chat.class);
        packets.put((byte) 4, Packet4UpdateTime.class);
        packets.put((byte) 5, Packet5EntityEquipment.class);
        packets.put((byte) 6, Packet6SpawnPosition.class);
        packets.put((byte) 7, Packet7UseEntity.class);
        packets.put((byte) 8, Packet8UpdateHealth.class);
        packets.put((byte) 9, Packet9Respawn.class);
        packets.put((byte) 10, Packet10Flying.class);
        packets.put((byte) 11, Packet11PlayerPosition.class);
        packets.put((byte) 12, Packet12PlayerLook.class);
        packets.put((byte) 13, Packet13PlayerLookMove.class);
        packets.put((byte) 14, Packet14BlockDig.class);
        packets.put((byte) 15, Packet15Place.class);
        packets.put((byte) 16, Packet16BlockItemSwitch.class);
        packets.put((byte) 17, Packet17EntityLocationAction.class);
        packets.put((byte) 18, Packet18ArmAnimation.class);
        packets.put((byte) 19, Packet19EntityAction.class);
        packets.put((byte) 20, Packet20NamedEntitySpawn.class);
        packets.put((byte) 21, Packet21PickupSpawn.class);
        packets.put((byte) 22, Packet22Collect.class);
        packets.put((byte) 23, Packet23VehicleSpawn.class);
        packets.put((byte) 24, Packet24MobSpawn.class);
        packets.put((byte) 25, Packet25EntityPainting.class);
        packets.put((byte) 27, Packet27.class);
        packets.put((byte) 28, Packet28EntityVelocity.class);
        packets.put((byte) 29, Packet29DestroyEntity.class);
        packets.put((byte) 30, Packet30Entity.class);
        packets.put((byte) 31, Packet31RelativeEntityMove.class);
        packets.put((byte) 32, Packet32EntityLook.class);
        packets.put((byte) 33, Packet33RelativeEntityMoveLook.class);
        packets.put((byte) 34, Packet34EntityTeleport.class);
        packets.put((byte) 38, Packet38EntityStatus.class);
        packets.put((byte) 39, Packet39AttachEntity.class);
        packets.put((byte) 40, Packet40EntityMetadata.class);
        packets.put((byte) 50, Packet50PreChunk.class);
        packets.put((byte) 51, Packet51MapChunk.class);
        packets.put((byte) 52, Packet52MultiBlockChange.class);
        packets.put((byte) 53, Packet53BlockChange.class);
        packets.put((byte) 54, Packet54PlayNoteBlock.class);
        packets.put((byte) 60, Packet60Explosion.class);
        packets.put((byte) 61, Packet61DoorChange.class);
        packets.put((byte) 70, Packet70Bed.class);
        packets.put((byte) 71, Packet71Weather.class);
        packets.put((byte) 100, Packet100OpenWindow.class);
        packets.put((byte) 101, Packet101CloseWindow.class);
        packets.put((byte) 102, Packet102WindowClick.class);
        packets.put((byte) 103, Packet103SetSlot.class);
        packets.put((byte) 104, Packet104WindowItems.class);
        packets.put((byte) 105, Packet105CraftProgressBar.class);
        packets.put((byte) 106, Packet106Transaction.class);
        packets.put((byte) 130, Packet130UpdateSign.class);
        packets.put((byte) 131, Packet131MapData.class);
        packets.put((byte) 200, Packet200Statistic.class);
        packets.put((byte) 254, Packet254ServerListPing.class);
        packets.put((byte) 255, Packet255KickDisconnect.class);
    }

    public static boolean containsID(byte id){
        if(packets.containsKey(id)){
            return true;
        } else {
            return false;
        }
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
            throw new RuntimeException("Packet ID does not match read ID for " + packet.getClass().getCanonicalName() + "; packet says " + packet.getId() + "; actual is " + id);
        }
        return packet;
    }

    public static Packet read(byte id, DataInputStream stream) throws UnknownPacketException, IOException {
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
