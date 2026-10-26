package main.lld.behavioral.state.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;
import main.lld.behavioral.state.model.Document;

@Data
@AllArgsConstructor
public class Published implements DocumentState {
    @Override
    public void publish(Document document) {
        System.out.println("Document is already published. No further action needed.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document is already approved and published. No further action needed.");
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("Cannot edit document in Published state. Please unpublish it first.");
    }

    @Override
    public void review(Document document) {
        System.out.println("Cannot review document in Published state. Please unpublish it first.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject document in Published state. Please unpublish it first.");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Document unpublished. Transitioning back to Draft state.");
        document.setState(new Draft());
    }
}
