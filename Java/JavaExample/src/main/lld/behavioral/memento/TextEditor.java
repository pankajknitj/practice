package main.lld.behavioral.memento;

public class TextEditor {
    private String txt = "";
    private int cursorPosition = 0;

    public void type(String txt){
        System.out.println("Typed: " + txt);
        this.txt += txt;
        cursorPosition += txt.length();
    }
    public TextEditorMemento save(){
        System.out.println("Taking Snapshot...");
        return new TextEditorMemento(txt,cursorPosition);
    }
    public void undo(TextEditorMemento memento){
        System.out.println("Restoring the Snapshot");
        txt = memento.getState();
        cursorPosition = memento.getCursorPosition();
    }
    public void print(){
        System.out.println("Content: " + txt + ", Cursor Position: " + cursorPosition);
    }
}
