package main.lld.creational.factorymethod.notification;

import main.lld.creational.factorymethod.Notification;

public class PushNotification implements Notification {
    public void send(String msg) {
        System.out.println("Sending push notification with message: " + msg);
    }
}
