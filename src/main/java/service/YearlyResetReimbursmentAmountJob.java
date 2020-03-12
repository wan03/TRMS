package service;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.CronScheduleBuilder;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import pojos.Employee;
import pojos.User;
import DAO.UserDAOImpl;

import java.util.List;

public class YearlyResetReimbursmentAmountJob implements Job {

	
	private UserDAOImpl userDao = new UserDAOImpl();
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
			
		List<User> employees = userDao.readAllUsers();
		
		for (User user : employees) {
			Employee employee = (Employee) user;
			userDao.updateUser(employee, "available_reimbursement", 1000);
		}
		

	}
	
	public void YearlyResetReimbursmentAmount() {
		  SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		  Scheduler sched;
		try {
			sched = schedFact.getScheduler();
			sched.start();


		JobDetail yearlyResetJob = newJob(AutoApproveJob.class)
				.withIdentity("yearlyResetJob", "reimbursementGroup")
				.build();
		
		  Trigger yearlyResetTrigger = newTrigger()
			      .withIdentity("yearlyResetTrigger", "reimbursementGroup")
			      .startNow()
			      .withSchedule(CronScheduleBuilder.cronSchedule("1 0 0 1 1 ?"))
			      .build();
		  
		  sched.scheduleJob(yearlyResetJob, yearlyResetTrigger);
		  
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
