package com.cts.scheduletraining.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.scheduletraining.dao.ViewTrainingScheduleDAO;
import com.cts.scheduletraining.vo.TrainingScheduleVO;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewTrainingScheduleDAOImplTest extends TestCase {

	@Autowired(required=true)
	ViewTrainingScheduleDAO viewTrainingScheduleDAO;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewSchedule() throws ParseException {
		String startDateString = "2017-08-01";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate=df.parse(startDateString);
		System.out.println(startDate);
		List<TrainingScheduleVO> list=new ArrayList<TrainingScheduleVO>();
		list=viewTrainingScheduleDAO.viewSchedule(startDate);
				Assert.assertEquals(1, list.size());
	}

}
