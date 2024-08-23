package br.com.gustavoakira.library.notification.adapter.outbound.job;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import br.com.gustavoakira.library.notification.adapter.outbound.service.EmailService;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;
import jakarta.mail.SendFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class NotificationItemProcessor implements ItemProcessor<NotificationEntity,NotificationEntity> {
    @Autowired
    private EmailService service;

    @Override
    public NotificationEntity process(NotificationEntity item) throws Exception {
        try{
            service.sendEmail(item.getEmail(),item.getMessage(), item.getMessage());
            item.setStatus(NotificationStatus.finished().getStatus());
        }catch (SendFailedException ex){
            log.error(ex.getMessage());
            item.setStatus(NotificationStatus.failed().getStatus());
        }
        return item;
    }
}
