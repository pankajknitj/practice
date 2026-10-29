package main.lld.behavioral.memento;

import lombok.Data;

@Data
public class TextEditorMemento {
    private final String state;
    private final int cursorPosition;
}
