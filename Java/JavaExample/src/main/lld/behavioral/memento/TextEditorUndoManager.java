package main.lld.behavioral.memento;

import java.util.Stack;

public class TextEditorUndoManager {
    Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor textEditor){
        history.push(textEditor.save());
    }
    public void restore(TextEditor textEditor){
        if(!history.isEmpty())
            textEditor.undo(history.pop());
        else System.out.println("Not have any saved state");
    }
}
