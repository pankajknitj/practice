package main.lld.creational.factorymethod.notification;

import main.lld.creational.factorymethod.Notification;

public class WhatsAppNotification implements Notification {
    public void send(String msg) {
        System.out.println("Sending WhatsApp notification with message: " + msg);
    }
}
