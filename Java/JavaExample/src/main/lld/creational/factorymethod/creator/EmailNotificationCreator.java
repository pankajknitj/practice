package main.lld.creational.factorymethod.creator;

import main.lld.creational.factorymethod.AbstractNotificationCreator;
import main.lld.creational.factorymethod.Notification;
import main.lld.creational.factorymethod.notification.EmailNotification;

public class EmailNotificationCreator extends AbstractNotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
