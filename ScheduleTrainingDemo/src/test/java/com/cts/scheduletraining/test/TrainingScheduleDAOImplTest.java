package com.cts.scheduletraining.test;

import javax.transaction.Transactional;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.scheduletraining.dao.TrainingScheduleDAO;
import com.cts.scheduletraining.entity.TrainingSchedule;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainingScheduleDAOImplTest extends TestCase {

	@Autowired(required=true)
	TrainingScheduleDAO trainingScheduleDAO;
	
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSaveScheduleDetail() {
		TrainingSchedule trainingSchedule = (TrainingSchedule) sessionFactory
				.getCurrentSession().get(TrainingSchedule.class, 67776l);
		Assert.assertEquals(5,trainingSchedule.getTrainerInfo().getTrainerId().toString().length());

	}

}
