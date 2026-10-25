package main.lld.behavioral.command.smarthome.invoker;

import main.lld.behavioral.command.smarthome.command.Command;

public interface HomeInvoker {
    public void executeCommand(Command command);
    public void undoLastCommand();
}
