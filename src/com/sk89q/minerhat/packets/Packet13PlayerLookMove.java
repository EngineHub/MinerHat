package com.sk89q.minerhat.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet13PlayerLookMove extends Packet10Flying {
    
    public double x;
    public double a; // Either Y or Stance -- Y if from Client, otherwise it's Stance -- Stupid Notch
    public double b; // Either Y or Stance -- Stance if from Client, other it's Y -- Stupid Notch
    public double z;
    public float yaw;
    public float pitch;

    @Override
    public void read(DataInputStream stream) throws IOException {
        this.x = stream.readDouble();
        this.a = stream.readDouble();
        this.b = stream.readDouble();
        this.z = stream.readDouble();
        this.yaw = stream.readFloat();
        this.pitch = stream.readFloat();
        super.read(stream);
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeDouble(this.x);
        stream.writeDouble(this.a);
        stream.writeDouble(this.b);
        stream.writeDouble(this.z);
        stream.writeFloat(this.yaw);
        stream.writeFloat(this.pitch);
        super.write(stream);
    }

    @Override
    public int length() {
        return 13;
    }

    @Override
    public byte getId() {
        return 13;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName() + " -> ");
        result.append("X: ");
        result.append(this.x);
        result.append(" Y: ");
        
        if(this.toServer){
            result.append(this.a);            
        } else {
            result.append(this.b);
        }
        
        result.append(" Z: ");
        result.append(z);
        result.append(" Yaw: ");
        result.append(yaw);
        result.append(" Pitch: ");
        result.append(pitch);
        result.append(" Stance: ");

        if(this.toServer){
            result.append(this.b);            
        } else {
            result.append(this.a);
        }
        
        return result.toString();
    }
}
