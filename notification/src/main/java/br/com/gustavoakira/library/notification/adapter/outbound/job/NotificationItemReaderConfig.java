package br.com.gustavoakira.library.notification.adapter.outbound.job;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import br.com.gustavoakira.library.notification.application.domain.Notification;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class NotificationItemReaderConfig {

    private final DataSource dataSource;

    public NotificationItemReaderConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public ItemReader<NotificationEntity> notificationItemReader() {
        String sql = "SELECT * FROM notification_entity where status='start'";
        return new JdbcCursorItemReaderBuilder<NotificationEntity>()
                .name("notificationItemReader")
                .sql(sql)
                .dataSource(dataSource)
                .rowMapper(new NotificationEntityMapper())
                .build();
    }
}
