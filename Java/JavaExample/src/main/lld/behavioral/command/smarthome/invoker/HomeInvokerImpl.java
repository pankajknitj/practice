package main.lld.behavioral.command.smarthome.invoker;

import lombok.Data;
import main.lld.behavioral.command.smarthome.command.Command;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

@Data
public class HomeInvokerImpl implements HomeInvoker {
    //supporting only 10 commands in history
    private Deque<Command> history = new LinkedList<>();

    @Override
    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
        if(history.size()>10){
            history.pollLast();
        }
    }

    @Override
    public void undoLastCommand() {
        Objects.requireNonNull(history.pollLast()).undo();
    }
}
