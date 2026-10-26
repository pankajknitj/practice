package main.lld.behavioral.state.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;
import main.lld.behavioral.state.model.Document;

@Data
@AllArgsConstructor
public class Approved implements DocumentState {
    @Override
    public void publish(Document document) {
        System.out.println("Document published. Transitioning to Publishing state.");
        document.setState(new Publishing());
        System.out.println("Document is now in Publishing state.");
        document.setState(new Published());
    }

    @Override
    public void approve(Document document) {

    }

    @Override
    public void edit(Document document, String content) {

    }

    @Override
    public void review(Document document) {

    }

    @Override
    public void reject(Document document) {

    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Document unpublished. Transitioning back to Draft state.");
    }
}
