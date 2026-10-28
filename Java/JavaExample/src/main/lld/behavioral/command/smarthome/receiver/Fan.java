package main.lld.behavioral.command.smarthome.receiver;

import lombok.Data;

@Data
//Receiver-1
public class Fan {
    private int speed;;

    public int getCurrentSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
        if(speed >0)
            System.out.println("Fan speed set to: " + speed);
        else System.out.println("Fan is turned off");
    }
}
