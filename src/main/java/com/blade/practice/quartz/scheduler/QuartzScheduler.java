package com.blade.practice.quartz.scheduler;

import com.blade.practice.quartz.job.TestJob1;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author blade
 * 2019/9/4 16:59
 */
@Component
public class QuartzScheduler {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    static Scheduler scheduler;

    public void scheduleJobs() throws SchedulerException {
        scheduler = schedulerFactoryBean.getScheduler();
        startJob1(); // 每5分钟执行一次
    }

    public static void startJob1() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(TestJob1.class).withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    public static void modifyJob1(String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger newTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, newTrigger);
    }

    public static String getJob1Status() throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
        return scheduler.getTriggerState(triggerKey).name();
    }

    public static void pauseJob1() throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey("job1", "group1"));
    }

    public static void resumeJob1() throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey("job1", "group1"));
    }
}
