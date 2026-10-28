package main.lld.behavioral.state.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;
import main.lld.behavioral.state.model.Document;

@Data
@AllArgsConstructor
//State-2
public class Review implements DocumentState {

    @Override
    public void publish(Document document) {
        System.out.println("Cannot publish document in Review state. Please approve it first.");
    }

    //allowed
    @Override
    public void approve(Document document) {
        System.out.println("Document approved. Transitioning to Approved state.");
        document.setState(new Approved());
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("Cannot edit document in Review state. Please reject it first.");
    }

    @Override
    public void review(Document document) {
        System.out.println("Document is already in Review state.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document rejected. Transitioning back to Draft state.");
        document.setState(new Draft());
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Cannot unpublish document in Review state. Document is not published yet.");
    }
}
