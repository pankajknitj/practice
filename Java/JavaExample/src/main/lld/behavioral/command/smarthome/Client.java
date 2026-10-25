package main.lld.behavioral.command.smarthome;

import main.lld.behavioral.command.smarthome.command.Command;
import main.lld.behavioral.command.smarthome.command.FanSpeedCommand;
import main.lld.behavioral.command.smarthome.command.LightOffCommand;
import main.lld.behavioral.command.smarthome.command.LightOnCommand;
import main.lld.behavioral.command.smarthome.invoker.HomeInvoker;
import main.lld.behavioral.command.smarthome.invoker.HomeInvokerImpl;
import main.lld.behavioral.command.smarthome.receiver.Fan;
import main.lld.behavioral.command.smarthome.receiver.Light;

public class Client {
    public static void main(String[] args) {
        HomeInvoker smartHome = new HomeInvokerImpl();

        //receivers
        Light light = new Light();
        Fan fan = new Fan();

        // Create commands
        Command turnOnLights = new LightOnCommand(light);
        Command turnOffLights = new LightOffCommand(light);
        Command fanSpeedCmd = new FanSpeedCommand(0,5,fan);

        //invoke
        smartHome.executeCommand(turnOnLights);
        smartHome.executeCommand(turnOffLights);
        smartHome.undoLastCommand();
        smartHome.executeCommand(fanSpeedCmd);
        smartHome.undoLastCommand();
    }
}
