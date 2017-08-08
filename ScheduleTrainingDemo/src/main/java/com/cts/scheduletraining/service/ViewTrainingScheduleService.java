package com.cts.scheduletraining.service;

import java.util.Date;
import java.util.List;

import com.cts.scheduletraining.vo.TrainingScheduleVO;

public interface ViewTrainingScheduleService {

	public List<TrainingScheduleVO> viewSchedule(Date startDate);

}
