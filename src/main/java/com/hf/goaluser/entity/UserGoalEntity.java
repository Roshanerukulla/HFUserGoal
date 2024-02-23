package com.hf.goaluser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class UserGoalEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ug_id")
	private Long ug_id;
	
	@Column(name="user_id")
	private Long user_id;
	
	
	GoalDTO goal1;
	public Long getUg_id() {
		return ug_id;
	}
	public void setUg_id(Long ug_id) {
		this.ug_id = ug_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public GoalDTO getGoal1() {
		return goal1;
	}
	public void setGoal1(GoalDTO goal1) {
		this.goal1 = goal1;
	}
	public GoalDTO getGoal2() {
		return goal2;
	}
	public void setGoal2(GoalDTO goal2) {
		this.goal2 = goal2;
	}
	public GoalDTO getGoal3() {
		return goal3;
	}
	public void setGoal3(GoalDTO goal3) {
		this.goal3 = goal3;
	}
	GoalDTO goal2;
	GoalDTO goal3;
	
		
	}