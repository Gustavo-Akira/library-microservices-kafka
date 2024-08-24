package br.com.gustavoakira.library.notification.adapter.outbound.job;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.SpringDataNotificationRepository;
import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class NotificationItemWriter implements ItemWriter<NotificationEntity> {
    @Autowired
    private SpringDataNotificationRepository repository;


    @Override
    public void write(Chunk<? extends NotificationEntity> chunk) throws Exception {
        repository.saveAll(chunk);
    }
}
