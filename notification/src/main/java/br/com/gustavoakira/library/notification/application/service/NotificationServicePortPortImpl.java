package br.com.gustavoakira.library.notification.application.service;

import br.com.gustavoakira.library.notification.application.domain.Notification;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;
import br.com.gustavoakira.library.notification.application.port.NotificationRepositoryPort;
import br.com.gustavoakira.library.notification.application.port.NotificationServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationServicePortPortImpl implements NotificationServicePort {

    private final NotificationRepositoryPort port;

    public NotificationServicePortPortImpl(NotificationRepositoryPort port) {
        this.port = port;
    }

    @Override
    public Notification save(Notification notification) {
        return port.save(notification);
    }

    @Override
    public Notification getNotification(Long id) {
        return port.getNotification(id);
    }

    @Override
    public List<Notification> findAllByStatus(NotificationStatus status) {
        return port.findAllByStatus(status);
    }
}
