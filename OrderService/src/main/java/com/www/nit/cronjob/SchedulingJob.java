package com.www.nit.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingJob {
	
	@Scheduled(cron = "0 * * * * *")
	public void sendBalanceNotification() {
		System.out.println(" Maintain Minimun Balance ");
	}

}
