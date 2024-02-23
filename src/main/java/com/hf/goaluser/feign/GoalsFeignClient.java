package com.hf.goaluser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HFGoals", url = "http://localhost:8080")
public interface GoalsFeignClient {

    @GetMapping("/api/goals/{goalId}")
    String getGoal(@PathVariable Long goalId);
}
