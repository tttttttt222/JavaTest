package com.test.quartz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/2/13
 */
public class HelloQuartz implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		String name = jobDetail.getJobDataMap().getString("name");
		System.out.println(name + "--"+new Date());
	}
}
