package main.lld.behavioral.memento;

public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorUndoManager undoManager = new TextEditorUndoManager();

        editor.type("Hello");
        editor.type(" World");

        undoManager.save(editor);

        editor.type("!");

        editor.print();

        undoManager.restore(editor);
        editor.print();

    }
}
