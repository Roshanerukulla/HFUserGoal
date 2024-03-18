package com.hf.goaluser.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hf.goaluser.entity.UserGoalEntity;
import com.hf.goaluser.feign.GoalsFeignClient;
import com.hf.goaluser.feign.UserFeignClient;
import com.hf.goaluser.response.GoalResponse;
import com.hf.goaluser.response.UserResponse;
import com.hf.goaluser.service.UserGoalServiceImpl;

@RestController
@RequestMapping("/api/user-goals-mapping")
public class UserGoalController {
    @Autowired
    private UserGoalServiceImpl us;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private GoalsFeignClient goalsFeignClient;

    @PostMapping
    public ResponseEntity<UserGoalEntity> createUserGoalsMapping(@RequestBody UserGoalEntity ug) {
        // Validate user and goals exist
        UserResponse user = userFeignClient.getUser(ug.getUserId());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        GoalResponse goal1 = goalsFeignClient.getGoal(ug.getGoalId1());
        GoalResponse goal2 = goalsFeignClient.getGoal(ug.getGoalId2());
        GoalResponse goal3 = goalsFeignClient.getGoal(ug.getGoalId3());

        if (goal1 == null || goal2 == null || goal3 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserGoalEntity savedMapping = us.saveUserGoalsMapping(ug);
        return new ResponseEntity<>(savedMapping, HttpStatus.CREATED);
    }

    @GetMapping("/{mappingId}")
    public ResponseEntity<UserGoalEntity> getUserGoalsMapping(@PathVariable Long mappingId) {
        Optional<UserGoalEntity> mapping = us.getUserGoalsMappingById(mappingId);
        return mapping.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/getmygoals/{userId}")
    public ResponseEntity<String> getUserInfo(@PathVariable Long userId) {
        // Fetch user information
        UserResponse user = userFeignClient.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // Fetch user's selected goals
        UserGoalEntity ug = us.getUserGoalsMappingByUserId(userId);
        if (ug == null) {
            return new ResponseEntity<>("User's goals not found", HttpStatus.NOT_FOUND);
        }

        GoalResponse goal1 = goalsFeignClient.getGoal(ug.getGoalId1());
        GoalResponse goal2 = goalsFeignClient.getGoal(ug.getGoalId2());
        GoalResponse goal3 = goalsFeignClient.getGoal(ug.getGoalId3());

        // Display a message with user's name and selected goals
        String message = "Hi " + user.getFirstName() + ", your selected goals are: "
                + goal1.getGoalName() + ", " + goal2.getGoalName() + ", " + goal3.getGoalName();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
