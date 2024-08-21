package br.com.gustavoakira.library.notification.application.port;

import br.com.gustavoakira.library.notification.application.domain.Notification;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;

import java.util.List;

public interface NotificationRepositoryPort {
    Notification save(Notification notification);
    Notification getNotification(Long id);
    List<Notification> findAllByStatus(NotificationStatus status);

}
