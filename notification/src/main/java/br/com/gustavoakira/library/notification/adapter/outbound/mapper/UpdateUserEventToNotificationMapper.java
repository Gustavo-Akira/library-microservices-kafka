package br.com.gustavoakira.library.notification.adapter.outbound.mapper;

import br.com.gustavoakira.library.common.adapters.event.UpdateUserEvent;
import br.com.gustavoakira.library.notification.application.domain.Notification;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserEventToNotificationMapper {
    public Notification toNotification(UpdateUserEvent event){
        return new Notification(event.email(), event.userId());
    }
}
