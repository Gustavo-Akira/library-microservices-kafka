package br.com.gustavoakira.library.notification.adapter.outbound.persistence;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import br.com.gustavoakira.library.notification.application.domain.Notification;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificationRepositoryPortImplTest {

    @InjectMocks
    private NotificationRepositoryPortImpl port;

    @Mock
    private SpringDataNotificationRepository repository;

    @Test
    void save() {
        Notification notification = Instancio.create(Notification.class);
        NotificationEntity entity = NotificationEntity.fromDomain(notification);
        NotificationEntity savedEntity = NotificationEntity.fromDomain(notification);
        savedEntity.setId(1L);
        Mockito.when(repository.save(entity)).thenReturn(savedEntity);
        notification = port.save(notification);
        Notification finalNotification = notification;
        assertAll(()->assertNotNull(finalNotification),()->assertEquals(1L, finalNotification.getId()));
    }

    @Test
    void getNotification() {
    }

    @Test
    void findAllByStatus() {
    }
}