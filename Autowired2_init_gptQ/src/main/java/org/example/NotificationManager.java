package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {
    private final NotificationSercvice notificationSercvice;

    @Autowired
    public NotificationManager(NotificationSercvice notificationSercvice) {
        this.notificationSercvice = notificationSercvice;
    }

    public NotificationSercvice getNotificationSercvice() {
        return notificationSercvice;
    }

    void notifyUser(String message){
        notificationSercvice.send(message);
    }
}
