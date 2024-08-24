package br.com.gustavoakira.library.notification.adapter.configuration;

import br.com.gustavoakira.library.notification.adapter.outbound.job.NotificationItemProcessor;
import br.com.gustavoakira.library.notification.adapter.outbound.job.NotificationItemWriter;
import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
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
    private final String JOB_NAME = "notificationSenderJob";
    private final String STEP_NAME = "notificationSenderStep";
    private final ItemReader<NotificationEntity> itemReader;
    int randomInt = new Random().nextInt();

    public NotificationSendJobConfig(JobRepository repository, PlatformTransactionManager manager, ItemReader<NotificationEntity> itemReader) {
        this.repository = repository;
        this.manager = manager;
        this.itemReader = itemReader;
    }

    @Bean
    public Step sendEmail(){
        return new StepBuilder(STEP_NAME,repository)
                .<NotificationEntity, NotificationEntity>chunk(50,manager)
                .reader(itemReader)
                .processor(processor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public ItemProcessor<NotificationEntity, NotificationEntity> processor(){
        return new NotificationItemProcessor();
    }

    @Bean
    public ItemWriter<NotificationEntity> itemWriter(){
        return new NotificationItemWriter();
    }

    @Bean
    public Job sendNotificationJob(){
        return new JobBuilder(JOB_NAME+randomInt,repository)
                .start(sendEmail())
                .build();
    }


}
