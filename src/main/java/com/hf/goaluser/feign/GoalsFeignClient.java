package com.hf.goaluser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hf.goaluser.response.GoalResponse;

@FeignClient(name = "HFGoals", url = "http://localhost:8080")

public interface GoalsFeignClient {

	/*
	 * @PostMapping("/api/goals") Goal createGoal(@RequestBody Goal goal);
	 */

	@GetMapping("/api/goals/{goalId}")
    GoalResponse getGoal(@PathVariable Long goalId);

}
