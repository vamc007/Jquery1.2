package com.cts.scheduletraining.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="training_schedule")
public class TrainingSchedule {
	@Id
	@Column(name="schedule_id")
	private Long scheduleId;
	
	@JoinColumn(name="trainer_id")
	@OneToOne(cascade=CascadeType.ALL)
	private TrainerInfo trainerInfo;
	
	@Column(name="college_name")
	private String collegeName;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="duration")
	private Long duration;
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public TrainerInfo getTrainerInfo() {
		return trainerInfo;
	}
	public void setTrainerInfo(TrainerInfo trainerInfo) {
		this.trainerInfo = trainerInfo;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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
	
}
