package main.lld.behavioral.command.smarthome.invoker;

import main.lld.behavioral.command.smarthome.command.Command;
//Invoker contract
public interface HomeInvoker {
    public void executeCommand(Command command);
    public void undoLastCommand();
}
