package com.blade.practice.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author blade
 * 2019/9/4 16:22
 */
@Component
@EnableScheduling
public class TestJob1 implements Job {

    private SimpleDateFormat dateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务1执行....当前时间为" + dateFormat().format(new Date()));
    }
}
