package br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;
import br.com.gustavoakira.library.notification.application.domain.Notification;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String message;
    private String status;

    public static NotificationEntity fromDomain(Notification notification) {
        NotificationEntity entity = new NotificationEntity();
        entity.setId(notification.getId());
        entity.setEmail(notification.getEmail());
        entity.setStatus(notification.getStatus().getStatus());
        entity.setMessage(notification.getValue());
        return entity;
    }

    public Notification toDomain() {
        switch (status){
            case "start":
                return new Notification(id,email,message,NotificationStatus.start());
            case "failed":
                return new Notification(id,email,message,NotificationStatus.failed());
            case "finished":
                return new Notification(id,email,message,NotificationStatus.finished());
            default:
                throw new InvalidDomainConversionException("Status of notification Invalid");
        }

    }
}
