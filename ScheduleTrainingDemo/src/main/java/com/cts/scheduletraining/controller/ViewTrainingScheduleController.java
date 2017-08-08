package com.cts.scheduletraining.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.scheduletraining.service.ViewTrainingScheduleService;
import com.cts.scheduletraining.vo.TrainingScheduleVO;


@Controller
public class ViewTrainingScheduleController {

	private static Logger logger=Logger.getLogger("ViewTrainingScheduleContoller.class");
	
	@Autowired(required=true)
	ViewTrainingScheduleService viewTrainingScheduleService;
	
	@RequestMapping("/retrievetrainingschedule")
	public ModelAndView displayRetrievePage()
	{
		logger.info("in displayRetrievePage()");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("schedule",new TrainingScheduleVO());
		modelAndView.setViewName("retrievetrainingschedule");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/view/schedule",method=RequestMethod.GET)
	public ModelAndView retrieveSchedule(@Valid @ModelAttribute("schdedule") TrainingScheduleVO trainingScheduleVO,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("schedule",new TrainingScheduleVO());
			modelAndView.setViewName("retrievetrainingschedule");
			return modelAndView;
		}
		else
		{
		List<TrainingScheduleVO> list=viewSchedule(trainingScheduleVO.getStartDate());
		logger.info("list size "+list.size());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("list",list);
		modelAndView.addObject("schedule",new TrainingScheduleVO());
		modelAndView.setViewName("retrievetrainingschedule");
		return modelAndView;
		}
		
	}
	
	public List<TrainingScheduleVO> viewSchedule(Date startDate)
	{
		return viewTrainingScheduleService.viewSchedule(startDate);
	}

}
