package com.cts.scheduletraining.bo;

import org.springframework.stereotype.Component;

@Component
public class TrainingScheduleBOImpl  implements TrainingScheduleBO{

	
	public Long generateId() {
		// TODO Auto-generated method stub
		Double id=Math.random()*1000000.;
		return id.longValue();
	}
	

}
