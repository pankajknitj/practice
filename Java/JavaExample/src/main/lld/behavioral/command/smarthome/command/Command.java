package main.lld.behavioral.command.smarthome.command;

//command contract
public interface Command {
    void execute();
    void undo();
}
