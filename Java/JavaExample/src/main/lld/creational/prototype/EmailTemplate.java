package main.lld.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailTemplate implements Clonable<EmailTemplate>{
    private String sub;
    private String body;
    //mutable field
    private RecipientList recipientList;

    @Override
    public EmailTemplate clone() {
        return new EmailTemplate(sub,
                body,
                recipientList.deepCopy());
    }

    public void send(){
        System.out.println("sent to: " + recipientList.getTo().toString());
        System.out.println("copied to: " + recipientList.getCc().toString());
    }
}
