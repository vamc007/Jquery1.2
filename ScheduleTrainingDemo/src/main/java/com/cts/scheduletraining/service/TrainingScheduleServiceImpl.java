package com.cts.scheduletraining.service;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.scheduletraining.dao.TrainingScheduleDAO;
import com.cts.scheduletraining.vo.TrainingScheduleVO;

@Service
public class TrainingScheduleServiceImpl implements TrainingScheduleService{

	private static Logger logger=Logger.getLogger("TrainingScheduleServiceImpl.class");

	@Autowired(required=true)
	TrainingScheduleDAO trainingScheduleDAO;
	
	@Transactional
	public Boolean addSchedule(TrainingScheduleVO trainingScheduleVO) {

		logger.info("in service");
		return trainingScheduleDAO.saveScheduleDetail(trainingScheduleVO);
	}
	

}
