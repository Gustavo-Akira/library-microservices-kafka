package br.com.gustavoakira.library.notification.adapter.outbound.persistence;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
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
        return repository.save(NotificationEntity.fromDomain(notification)).toDomain();
    }

    @Override
    public Notification getNotification(Long id) {
        return repository.findById(id).orElseThrow().toDomain();
    }

    @Override
    public List<Notification> findAllByStatus(NotificationStatus status) {
        return repository.findAllByStatus(status.getStatus()).stream().map(NotificationEntity::toDomain).toList();
    }
}
