package br.com.gustavoakira.library.notification.adapter.configuration;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Random;

@Configuration
@EnableBatchProcessing
public class NotificationSendJobConfig {
    private final JobRepository repository;
    private final PlatformTransactionManager manager;
    private final DataSource source;
    private final String JOB_NAME = "notificationSenderJob";
    private final String STEP_NAME = "notificationSenderStep";
    int randomInt = new Random().nextInt();

    public NotificationSendJobConfig(JobRepository repository, PlatformTransactionManager manager, DataSource source) {
        this.repository = repository;
        this.manager = manager;
        this.source = source;
    }

    @Bean
    public Step sendEmail(){
        return new StepBuilder(STEP_NAME,repository)
                .<NotificationEntity, NotificationEntity>chunk(50,manager)
                .build();
    }

    @Bean
    public Job sendNotificationJob(){
        return new JobBuilder(JOB_NAME+randomInt,repository)
                .start(sendEmail())
                .build();
    }


}
