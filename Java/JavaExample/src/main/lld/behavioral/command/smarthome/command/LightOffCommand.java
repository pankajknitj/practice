package main.lld.behavioral.command.smarthome.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import main.lld.behavioral.command.smarthome.receiver.Light;

@Data
@AllArgsConstructor
public class LightOffCommand implements Command {
    private Light light;

    @Override
    public void execute() {
        System.out.print("Turning light off: ");
        light.off();
    }

    @Override
    public void undo() {
        System.out.print("Undoing Light Off Command: ");
        light.on();
    }
}
