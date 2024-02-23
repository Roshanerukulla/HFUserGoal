package com.hf.goaluser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hf.goaluser.entity.UserGoalEntity;
import com.hf.goaluser.service.UserGoalService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user-goals")
public class UserGoalController {

    @Autowired
    private UserGoalService userGoalService;

    @GetMapping("/{userId}")
    public UserGoalEntity getUserGoals(@PathVariable Long userId) {
        return userGoalService.getUserGoals(userId);
    }

    @PostMapping("/{userId}")
    public UserGoalEntity addUserGoals(@PathVariable Long userId, @RequestBody Map<String, Long> goals) {
        return userGoalService.addUserGoals(userId, goals);
    }
    @PutMapping("/update/{userId}/{goalKey}")
    public UserGoalEntity updateUserGoals(@PathVariable Long userId, @PathVariable String goalKey ,@RequestBody Map<String,Long> goals) {
    	return userGoalService.UpdateUserGoals(userId, goals, goalKey);
    }

    @DeleteMapping("/{userId}/{goalKey}")
    public void deleteUserGoal(@PathVariable Long userId, @PathVariable String goalKey) {
        userGoalService.deleteUserGoal(userId, goalKey);
    }
}
