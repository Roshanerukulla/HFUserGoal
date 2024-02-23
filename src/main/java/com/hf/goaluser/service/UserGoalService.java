package com.hf.goaluser.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hf.goaluser.entity.UserGoalEntity;
@Service
public interface UserGoalService {

    UserGoalEntity getUserGoals(Long userId);

    UserGoalEntity addUserGoals(Long userId, Map<String, Long> goals);
    UserGoalEntity UpdateUserGoals(Long userId,Map<String, Long> goals, String goalKey);
    void deleteUserGoal(Long userId, String goalKey);
}
