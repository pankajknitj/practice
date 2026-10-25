package main.lld.behavioral.iterator.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.iterator.face.Iterator;
import main.lld.behavioral.iterator.model.Notification;

import java.util.ArrayList;
import java.util.List;

import static main.lld.behavioral.iterator.model.NotificationType.EMAIL;

@Data
@AllArgsConstructor
public class EmailIterator implements Iterator<Notification> {
    private final NotificationCenter center;
    private int currentIndex = 0;

    public EmailIterator(NotificationCenter center){
        this.center = center;
        currentIndex = findNextIndex();
    }

    @Override
    public boolean hasNext() {
        return currentIndex<center.getSize();
    }

    @Override
    public Notification next() {
        Notification nextElement = center.getNotification(currentIndex++);
        currentIndex = findNextIndex();
        return nextElement;
    }

    private int findNextIndex(){
        for(int i=currentIndex;i<center.getSize();i++){
            if(EMAIL.equals(center.getNotification(i).getType())){
                return i;
            }
        }

        return center.getSize();
    }
}
