package main.lld.behavioral.iterator;

import main.lld.behavioral.iterator.face.Iterator;
import main.lld.behavioral.iterator.impl.NotificationCenter;
import main.lld.behavioral.iterator.model.Notification;

import static main.lld.behavioral.iterator.model.NotificationType.EMAIL;
import static main.lld.behavioral.iterator.model.NotificationType.SMS;

public class Client {
    public static void main(String[] args) {
        NotificationCenter center = new NotificationCenter();

        center.addNotification(new Notification("email1",EMAIL,false));
        center.addNotification(new Notification("email2",EMAIL,false));
        center.addNotification(new Notification("email3",EMAIL,true));

        center.addNotification(new Notification("sms1",SMS,false));
        center.addNotification(new Notification("sms2",SMS,false));

        Iterator<Notification> smsIterator = center.smsIterator();
        while(smsIterator.hasNext()) {
            Notification notification = smsIterator.next();
            System.out.println(notification);
        }

        Iterator<Notification> unreadEmailIterator = center.unreadIterator();
        while(unreadEmailIterator.hasNext()) {
            Notification notification = unreadEmailIterator.next();
            System.out.println(notification);
        }
    }
}
