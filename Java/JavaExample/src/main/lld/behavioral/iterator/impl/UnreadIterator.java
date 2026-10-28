package main.lld.behavioral.iterator.impl;

import main.lld.behavioral.iterator.face.Iterator;
import main.lld.behavioral.iterator.model.Notification;

import java.util.List;

import static main.lld.behavioral.iterator.model.NotificationType.EMAIL;
import static main.lld.behavioral.iterator.model.NotificationType.SMS;
// Concrete iterator class-3
public class UnreadIterator implements Iterator<Notification> {
    private final NotificationCenter center;
    private int currentIndex = 0;

    public UnreadIterator(NotificationCenter center){
        this.center = center;
    }
    @Override
    public boolean hasNext() {
        return currentIndex< center.getSize();
    }

    @Override
    public Notification next() {
        Notification nextElement = center.getNotification(currentIndex++);
        for(int i=currentIndex;i<center.getSize();i++){
            if(!center.getNotification(i).isRead()){
                currentIndex = i;
                return nextElement;
            }
        }
        return nextElement;
    }
}
