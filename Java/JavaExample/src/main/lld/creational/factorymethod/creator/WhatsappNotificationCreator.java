package main.lld.creational.factorymethod.creator;

import main.lld.creational.factorymethod.AbstractNotificationCreator;
import main.lld.creational.factorymethod.Notification;
import main.lld.creational.factorymethod.notification.EmailNotification;
import main.lld.creational.factorymethod.notification.WhatsAppNotification;

public class WhatsappNotificationCreator extends AbstractNotificationCreator {
    @Override
    public Notification createNotification() {
        return new WhatsAppNotification();
    }
}
