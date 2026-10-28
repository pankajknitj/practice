package main.lld.behavioral.state.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;
import main.lld.behavioral.state.model.Document;

@Data
@AllArgsConstructor
//State-4
public class Publishing implements DocumentState {
    @Override
    public void publish(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void approve(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void review(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void reject(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("not Supported. document is publishing...");
    }
}
