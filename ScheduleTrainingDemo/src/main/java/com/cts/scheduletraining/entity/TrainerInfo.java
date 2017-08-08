package com.cts.scheduletraining.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="trainer_info")
public class TrainerInfo {

	@Id
	@Column(name="trainer_id")
	private Long trainerId;
	
	@Column(name="trainer_name")
	private String trainerName;
	
	@Column(name="domain")
	private String domain;
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
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}

}
