package com.blade.practice.quartz.listener;

import com.blade.practice.quartz.scheduler.QuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author blade
 * 2019/9/4 16:55
 */
@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuartzScheduler scheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            scheduler.scheduleJobs();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
}
