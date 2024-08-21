package br.com.gustavoakira.library.notification.adapter.outbound.persistence;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataNotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
