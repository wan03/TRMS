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
import pojos.ReimbursementForm;
import DAO.ReimbursementFormDAO;
import java.time.LocalDate;
import java.util.List;

public class AutoApproveJob implements Job {
	
	private ReimbursementFormDAO formDao = new ReimbursementFormDAO();
	private ReimbursementFormService formService = new ReimbursementFormService();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<ReimbursementForm> forms = formDao.retrieveForms();
		LocalDate today = LocalDate.now();
		
		for (ReimbursementForm reimbursementForm : forms) {
			if (today.isAfter(reimbursementForm.getSubmitted().plusWeeks(2))) {
				if (reimbursementForm.getStatus().equals("approved by supervisor")) {
					formService.approveReimbursement("approved by DH", reimbursementForm.getReimbursementId());
				} else if (reimbursementForm.getStatus().equals("approved by supervisor")) {
					formService.approveReimbursement("approved by DH", reimbursementForm.getReimbursementId());
				} else if (reimbursementForm.getStatus().equals("approved by DH")) {
					//Figure out how to send an email to someone
				}
			}
		}

	}
	
	public void autoApproveReimbursement() {
		  SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		  Scheduler sched;
		try {
			sched = schedFact.getScheduler();
			sched.start();


		JobDetail autoApproveJob = newJob(AutoApproveJob.class)
				.withIdentity("autoApproveJob", "reimbursementGroup")
				.build();
		
		  Trigger approveTrigger = newTrigger()
			      .withIdentity("approveTrigger", "reimbursementGroup")
			      .startNow()
			      .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(9, 0))
			      .build();
		  
		  sched.scheduleJob(autoApproveJob, approveTrigger);
		  
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		  
	}

}
