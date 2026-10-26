package main.lld.behavioral.state.face;

import main.lld.behavioral.state.model.Document;

public interface DocumentState {
    void publish(Document document);
    void approve(Document document);
    void edit(Document document, String content);
    void review(Document document);
    void reject(Document document);
    void unpublish(Document document);
}
