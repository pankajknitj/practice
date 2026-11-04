package main.lld.creational.factorymethod.notification;

import main.lld.creational.factorymethod.Notification;

public class SlackNotification implements Notification {
    public void send(String msg) {
        System.out.println("Sending Slack notification with message: " + msg);
    }
}
