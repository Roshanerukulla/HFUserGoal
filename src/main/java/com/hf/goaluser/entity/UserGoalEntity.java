package com.hf.goaluser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usergoals")
public class UserGoalEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;

    private Long userId;

    private Long goalId1;

    private Long goalId2;

    private Long goalId3;

	public Long getMappingId() {
		return mappingId;
	}

	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGoalId1() {
		return goalId1;
	}

	public void setGoalId1(Long goalId1) {
		this.goalId1 = goalId1;
	}

	public Long getGoalId2() {
		return goalId2;
	}

	public void setGoalId2(Long goalId2) {
		this.goalId2 = goalId2;
	}

	public Long getGoalId3() {
		return goalId3;
	}

	public void setGoalId3(Long goalId3) {
		this.goalId3 = goalId3;
	}

	public UserGoalEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

    // getters, setters
}
