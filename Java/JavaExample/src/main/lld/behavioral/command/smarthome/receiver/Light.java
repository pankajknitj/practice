package main.lld.behavioral.command.smarthome.receiver;

import lombok.Data;

@Data
public class Light {
    public void on(){
        System.out.println("Light is ON");
    }

    public void off(){
        System.out.println("Light is OFF");
    }
}
