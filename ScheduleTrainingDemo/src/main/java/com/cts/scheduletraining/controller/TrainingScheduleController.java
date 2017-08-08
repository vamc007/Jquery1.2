package com.cts.scheduletraining.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.scheduletraining.service.TrainingScheduleService;
import com.cts.scheduletraining.vo.TrainingScheduleVO;

@RestController
public class TrainingScheduleController {
	
	private static Logger logger=Logger.getLogger("TrainingScheduleContoller.class");
	
	@Autowired(required=true)
	TrainingScheduleService trainingScheduleService;
	
	@RequestMapping("/home")
	public ModelAndView displayHome()
	{
		logger.info("in displayHome()");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	@RequestMapping("/inserttrainingschedule")
	public ModelAndView displayInsertPage()
	{
		logger.info("in displayInsertPage()");
		List<String> domainList=getDomain();
		List<String> durationList=getDuration();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("domainList",domainList);
		modelAndView.addObject("durationList", durationList);
		modelAndView.setViewName("inserttrainingschedule");
		return modelAndView;
	}
	public List<String> getDomain()
	{
		logger.info("domainlist");
		List<String> domain=new ArrayList<String>();
		domain.add("Java");
		domain.add("Spring");
		domain.add("hibernate");
		domain.add("data analysis");
		return domain;
	}
	
	public List<String> getDuration()
	{
		logger.info("durationlist");
		List<String> duration=new ArrayList<String>();
		duration.add("15");
		duration.add("30");
		duration.add("45");
		duration.add("60");
		duration.add("120");
		return duration;
	}
	@RequestMapping(value="/trainer/schedule",produces="application/json",method=RequestMethod.POST)
	public String insertSchedule(@RequestParam("trainerId") Long trainerId,@RequestParam("trainerName") String trainerName,
			@RequestParam("collegeName") String collegeName,@RequestParam("domain") String domain,
			@RequestParam("startDate") Date startDate,@RequestParam("duration") Long duration)
	{
		logger.info("in insertSchedule()");
		TrainingScheduleVO trainingScheduleVO=new TrainingScheduleVO();
		trainingScheduleVO.setCollegeName(collegeName);
		trainingScheduleVO.setDomain(domain);
		trainingScheduleVO.setDuration(duration);
		trainingScheduleVO.setStartDate(startDate);
		trainingScheduleVO.setTrainerId(trainerId);
		trainingScheduleVO.setTrainerName(trainerName);
		Boolean status=addSchedule(trainingScheduleVO);
		if(status)
		return "success";
		else
			return "error";
	}
	
	public Boolean addSchedule(TrainingScheduleVO trainingScheduleVO)
	{
		logger.info("in controller addschedule");
		Boolean status=trainingScheduleService.addSchedule(trainingScheduleVO);
		return status;
	}
	}


