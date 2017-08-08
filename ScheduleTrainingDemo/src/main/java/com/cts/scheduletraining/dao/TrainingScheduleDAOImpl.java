package com.cts.scheduletraining.dao;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.scheduletraining.bo.TrainingScheduleBO;
import com.cts.scheduletraining.entity.TrainerInfo;
import com.cts.scheduletraining.entity.TrainingSchedule;
import com.cts.scheduletraining.vo.TrainingScheduleVO;

@Repository
public class TrainingScheduleDAOImpl implements TrainingScheduleDAO{

	private static Logger logger=Logger.getLogger("TrainingScheduleDAOImpl.class");
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	@Autowired(required=true)
	private TrainingScheduleBO trainingScheduleBO;
	public Boolean saveScheduleDetail(TrainingScheduleVO trainingScheduleVO) {
		logger.info("in dao");
		try{
		TrainerInfo trainerInfo=new TrainerInfo();
		trainerInfo.setDomain(trainingScheduleVO.getDomain());
		trainerInfo.setTrainerId(trainingScheduleVO.getTrainerId());
		trainerInfo.setTrainerName(trainingScheduleVO.getTrainerName());
		TrainingSchedule trainingSchedule=new TrainingSchedule();
		trainingSchedule.setTrainerInfo(trainerInfo);
		trainingSchedule.setCollegeName(trainingScheduleVO.getCollegeName());
		trainingSchedule.setDuration(trainingScheduleVO.getDuration());
		trainingSchedule.setScheduleId(trainingScheduleBO.generateId());
		trainingSchedule.setStartDate(trainingScheduleVO.getStartDate());
		sessionFactory.getCurrentSession().save(trainingSchedule);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
