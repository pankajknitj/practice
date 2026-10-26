package main.lld.behavioral.state.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.state.face.DocumentState;

@Data
@AllArgsConstructor
public class Document {
    private String content;
    private DocumentState state;

    public void edit(String newContent) {
        System.out.println("Editing document...");
        state.edit(this, newContent);
    }

    public void sendForReview() {
        System.out.println("Sending document for review...");
        state.review(this);
    }

    public void approve() {
        System.out.println("Approving document...");
        state.approve(this);
    }

    public void reject() {
        System.out.println("Rejecting document...");
        state.reject(this);
    }

    public void publish() {
        System.out.println("Publishing document...");
        state.publish(this);
    }

    public void unpublish() {
        System.out.println("Unpublishing document...");
        state.unpublish(this);
    }
}
