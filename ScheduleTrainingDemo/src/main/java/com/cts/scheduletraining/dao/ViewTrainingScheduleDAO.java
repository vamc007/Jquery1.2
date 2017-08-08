package com.cts.scheduletraining.dao;

import java.util.Date;
import java.util.List;

import com.cts.scheduletraining.vo.TrainingScheduleVO;

public interface ViewTrainingScheduleDAO {

	
	public List<TrainingScheduleVO> viewSchedule(Date startDate);
}
