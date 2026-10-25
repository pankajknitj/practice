package main.lld.behavioral.command.smarthome.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import main.lld.behavioral.command.smarthome.receiver.Fan;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FanSpeedCommand implements Command {
    private int previousSpeed;
    private int newSpeed;
    private final Fan fan;

    @Override
    public void execute() {
        previousSpeed = fan.getCurrentSpeed();
        System.out.print("Setting Fan speed: ");
        fan.setSpeed(newSpeed);
    }

    @Override
    public void undo() {
        System.out.print("Undoing fan setting: ");
        fan.setSpeed(previousSpeed);
    }
}
