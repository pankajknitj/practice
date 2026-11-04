package main.lld.creational.factorymethod.notification;

import main.lld.creational.factorymethod.Notification;

public class EmailNotification implements Notification {
    public void send(String msg) {
        System.out.println("Sending email notification with message: " + msg);
    }
}
