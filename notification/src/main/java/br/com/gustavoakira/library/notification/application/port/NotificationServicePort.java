package br.com.gustavoakira.library.notification.application.port;

import br.com.gustavoakira.library.notification.application.domain.Notification;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;

import java.util.List;

public interface NotificationServicePort {
    Notification save(Notification notification);
    Notification getNotification(Long id);
    List<Notification> findAllByStatus(NotificationStatus status);
    default Notification updateNotification(Long id, Notification notification){
        Notification withId = new Notification(id, notification.getEmail(), notification.getValue(), notification.getStatus());
        return save(withId);
    }

}
