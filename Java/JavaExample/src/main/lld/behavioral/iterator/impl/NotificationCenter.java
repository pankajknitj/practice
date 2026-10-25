package main.lld.behavioral.iterator.impl;

import main.lld.behavioral.iterator.face.Iterable;
import main.lld.behavioral.iterator.face.Iterator;
import main.lld.behavioral.iterator.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter implements Iterable<Notification> {
    private List<Notification> notifications = new ArrayList<>();


    @Override
    public Iterator<Notification> emailIterator() {
        return new EmailIterator(this);
    }

    @Override
    public Iterator<Notification> smsIterator() {
        return new SMSIterator(this);
    }

    @Override
    public Iterator<Notification> unreadIterator() {
        return new UnreadIterator(this);
    }

    public int getSize(){
        return notifications.size();
    }

    public Notification getNotification(int index){
        return notifications.get(index);
    }

    public void addNotification(Notification notification){
        notifications.add(notification);
    }
}
