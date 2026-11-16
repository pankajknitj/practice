package main.lld.creational.prototype;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        RecipientList baseRecipients = new RecipientList(
                List.of("all@company.com"),
                List.of("archive@company.com"));

        EmailTemplate baseTemplate = new EmailTemplate(
                "Company Newsletter", "Monthly updates from the team...", baseRecipients);

        EmailTemplate marketingEmail = baseTemplate.clone();
        marketingEmail.setSub("Marketing Newsletter");
        marketingEmail.getRecipientList().addTo("marketing@company.com");

        EmailTemplate engineeringEmail = baseTemplate.clone();
        engineeringEmail.setSub("Engineering Newsletter");
        engineeringEmail.getRecipientList().addTo("eng-team@company.com");

        EmailTemplate hrEmail = baseTemplate.clone();
        hrEmail.setSub("HR Newsletter");
        hrEmail.getRecipientList().addTo("hr@company.com");
        hrEmail.getRecipientList().addCc("ceo@company.com");

        marketingEmail.send();
        engineeringEmail.send();
        hrEmail.send();

        System.out.println("\nBase template unchanged:");
        baseTemplate.send();
    }
}
