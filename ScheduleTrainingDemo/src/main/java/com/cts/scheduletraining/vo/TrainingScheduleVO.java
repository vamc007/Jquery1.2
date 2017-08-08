package com.cts.scheduletraining.vo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class TrainingScheduleVO {

	
	private Long trainerId;
	private String trainerName;
	private String collegeName;
	private String domain;
	@NotNull(message="Please select a date")
	@Future
	private Date startDate;
	private Long duration;
	public Long getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public TrainingScheduleVO(String trainerName, String collegeName,
			String domain, Date startDate, Long duration) {
		super();
		this.trainerName = trainerName;
		this.collegeName = collegeName;
		this.domain = domain;
		this.startDate = startDate;
		this.duration = duration;
	}
	public TrainingScheduleVO() {
		super();
	}

	
	
}
