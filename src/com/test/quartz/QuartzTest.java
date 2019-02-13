package com.test.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/2/13
 */
public class QuartzTest {

	public static void main(String[] args) {
		try {
			//创建scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			//定义一个Trigger
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义name/group
					.startNow()//一旦加入scheduler，立即生效
					.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")) //一直执行
//					.withSchedule(simpleSchedule() //使用SimpleTrigger
//							.withIntervalInSeconds(1) //每隔一秒执行一次
//							.repeatForever()) //一直执行
					.build();

			//定义一个JobDetail
			JobDetail jobDetail = newJob(HelloQuartz.class).withIdentity("job1", "group1")
					.usingJobData("name", "quartz")
					.build();

			scheduler.scheduleJob(jobDetail, trigger);

			scheduler.start();


		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}


}
