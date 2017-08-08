package com.cts.scheduletraining.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.scheduletraining.entity.TrainingSchedule;
import com.cts.scheduletraining.vo.TrainingScheduleVO;

@Repository
public class ViewTrainingScheduleDAOImpl implements ViewTrainingScheduleDAO{

	private static Logger logger=Logger.getLogger("ViewTrainingScheduleDAOImpl.class");
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	public List<TrainingScheduleVO> viewSchedule(Date startDate) {
	logger.info("in view dao");
	Session session=sessionFactory.getCurrentSession();
	logger.info("before query");
		List<TrainingSchedule> trainingSchedules=session.createQuery("from TrainingSchedule ts where ts.startDate>=:startDate").setParameter("startDate", startDate).list();
	logger.info("after query");
	List<TrainingScheduleVO> list=new ArrayList<TrainingScheduleVO>();
	
	for (TrainingSchedule schedule : trainingSchedules) {
		
		list.add(new TrainingScheduleVO(schedule.getTrainerInfo().getTrainerName(), schedule.getCollegeName(), schedule.getTrainerInfo().getDomain(),
				schedule.getStartDate(), schedule.getDuration()));
	}
	return list;
	}

}
