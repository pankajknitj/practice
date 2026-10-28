package main.lld.behavioral.command.smarthome.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import main.lld.behavioral.command.smarthome.receiver.Light;

@Data
@AllArgsConstructor
//Concrete command-1
public class LightOnCommand implements Command {
    private Light light;
    @Override
    public void execute() {
        System.out.print("Turning light ON: ");
        light.on();
    }

    @Override
    public void undo() {
        System.out.print("Undoing Light ON command: ");
        light.off();
    }
}
