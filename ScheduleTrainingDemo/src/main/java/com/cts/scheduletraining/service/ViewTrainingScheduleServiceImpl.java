package com.cts.scheduletraining.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.scheduletraining.dao.ViewTrainingScheduleDAO;
import com.cts.scheduletraining.vo.TrainingScheduleVO;

@Service
public class ViewTrainingScheduleServiceImpl implements ViewTrainingScheduleService{

	private static Logger logger=Logger.getLogger("TrainingScheduleServiceImpl.class");
	@Autowired(required=true)
	ViewTrainingScheduleDAO viewTrainingScheduleDAO;
	@Transactional
	public List<TrainingScheduleVO> viewSchedule(Date startDate) {
		logger.info("in view service");
		return viewTrainingScheduleDAO.viewSchedule(startDate);
	}
	

}
