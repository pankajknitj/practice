package main.lld.creational.factorymethod;

import main.lld.creational.factorymethod.creator.EmailNotificationCreator;
import main.lld.creational.factorymethod.creator.PushNotificationCreator;
import main.lld.creational.factorymethod.creator.WhatsappNotificationCreator;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        String message = "Hello World!";

        Notification emailNotification = new EmailNotificationCreator().createNotification();
        Notification pushNotification = new PushNotificationCreator().createNotification();

        emailNotification.send(message);
        pushNotification.send(message);
    }
}
