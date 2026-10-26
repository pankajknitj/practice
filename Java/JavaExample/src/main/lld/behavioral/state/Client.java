package main.lld.behavioral.state;

import main.lld.behavioral.state.impl.Draft;
import main.lld.behavioral.state.model.Document;

public class Client {
    public static void main(String[] args) {
        Document document = new Document("", new Draft());
        document.edit("This is a draft document.");
        document.sendForReview();
        document.approve();
        document.publish();
        document.unpublish();
        document.reject();
    }
}
