package br.com.gustavoakira.library.notification.adapter.outbound.persistence;

import br.com.gustavoakira.library.notification.application.domain.Notification;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;
import br.com.gustavoakira.library.notification.application.port.NotificationRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationRepositoryPortImpl implements NotificationRepositoryPort {
    private final SpringDataNotificationRepository repository;

    public NotificationRepositoryPortImpl(SpringDataNotificationRepository repository) {
        this.repository = repository;
    }


    @Override
    public Notification save(Notification notification) {
        return null;
    }

    @Override
    public Notification getNotification(Long id) {
        return null;
    }

    @Override
    public List<Notification> findAllByStatus(NotificationStatus status) {
        return null;
    }
}
