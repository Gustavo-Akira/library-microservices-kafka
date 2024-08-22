package br.com.gustavoakira.library.notification.adapter.outbound.persistence;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import br.com.gustavoakira.library.notification.application.domain.Notification;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificationRepositoryPortImplTest {

    @InjectMocks
    private NotificationRepositoryPortImpl port;

    @Mock
    private SpringDataNotificationRepository repository;
    Model<Notification> notificationModel = Instancio.of(Notification.class).set(field("status"), NotificationStatus.start()).toModel();


    @Test
    void save() {
        Notification notification = Instancio.create(notificationModel);

        NotificationEntity entity = NotificationEntity.fromDomain(notification);
        NotificationEntity savedEntity = NotificationEntity.fromDomain(notification);
        savedEntity.setId(1L);
        Mockito.when(repository.save(entity)).thenReturn(savedEntity);
        notification = port.save(notification);
        Notification finalNotification = notification;
        Mockito.verifyNoMoreInteractions(repository);
        assertAll(()->assertNotNull(finalNotification),()->assertEquals(1L, finalNotification.getId()));
    }

    @Test
    void getNotification() {
        Notification notification = Instancio.create(notificationModel);
        NotificationEntity savedEntity = NotificationEntity.fromDomain(notification);
        savedEntity.setId(1L);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(savedEntity));
        assertEquals(savedEntity.toDomain(),port.getNotification(1L));
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    void findAllByStatus() {
        List<Notification> notifications = Instancio.stream(notificationModel).limit(3).toList();
        List<NotificationEntity> entities = notifications.stream().map(NotificationEntity::fromDomain).collect(Collectors.toList());
        Mockito.when(repository.findAllByStatus("start")).thenReturn(entities);
        assertEquals(notifications,port.findAllByStatus(NotificationStatus.start()));
        Mockito.verifyNoMoreInteractions(repository);
    }
}