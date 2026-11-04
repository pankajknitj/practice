package main.lld.creational.factorymethod;

public abstract class AbstractNotificationCreator {
    public abstract Notification createNotification();

    //additional method.
    public void notifyUser(String msg){
        Notification notification = createNotification();
        notification.send(msg);
    }
}
