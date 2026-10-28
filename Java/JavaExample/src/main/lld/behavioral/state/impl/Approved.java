package main.lld.behavioral.state.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;
import main.lld.behavioral.state.model.Document;

@Data
@AllArgsConstructor
//State-3
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
        System.out.println("Rejected: Already Approved");
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("Rejected: Not allowed");
    }

    @Override
    public void review(Document document) {
        System.out.println("Rejected:not allowed");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Rejected: Not allowed");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Document unpublished. Transitioning back to Draft state.");
    }
}
