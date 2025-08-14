package manager;

import model.Message;
import org.springframework.stereotype.Component;
import service.NotificationService;

@Component
public class NotificationManager {
    private final NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void notifyUser(Message message){
        notificationService.sendNotification(message);
    }
}