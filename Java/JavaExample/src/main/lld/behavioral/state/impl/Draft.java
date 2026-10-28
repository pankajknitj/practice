package main.lld.behavioral.state.impl;

import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;
import main.lld.behavioral.state.model.Document;

import java.sql.SQLOutput;

@Data
//Concrete state-1
public class Draft implements DocumentState {
    //allowed
    @Override
    public void publish(Document document) {
        System.out.println("Cannot publish document in Draft state. Please send it for review first.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve document in Draft state. Please send it for review first.");
    }

    @Override
    public void edit(Document document, String content) {
        document.setContent(content);
        System.out.println("Document content updated in Draft state.");
    }

    //allowed
    @Override
    public void review(Document document) {
        System.out.println("Document sent for review. Transitioning to Review state.");
        document.setState(new Review());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject document in Draft state. Please send it for review first.");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Cannot unpublish document in Draft state. Document is not published yet.");
    }
}
