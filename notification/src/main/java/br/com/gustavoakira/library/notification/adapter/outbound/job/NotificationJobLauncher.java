package br.com.gustavoakira.library.notification.adapter.outbound.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class NotificationJobLauncher {
    private final JobLauncher launcher;
    private final Job sendNotificationJob;

    public NotificationJobLauncher(JobLauncher launcher, Job sendNotificationJob) {
        this.launcher = launcher;
        this.sendNotificationJob = sendNotificationJob;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void startJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        launcher.run(sendNotificationJob,new JobParametersBuilder().addDate("launchDate", new Date())
                .toJobParameters());
    }
}
