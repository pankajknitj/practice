package main.lld.behavioral.iterator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Notification {
    private String message;
    private NotificationType type;
    private boolean isRead=false;
}
