package com.hf.goaluser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hf.goaluser.entity.UserGoalEntity;
import com.hf.goaluser.feign.GoalsFeignClient;
import com.hf.goaluser.feign.UserFeignClient;
import com.hf.goaluser.repository.UserGoalRepository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

@Service
public class UserGoalServiceImpl {
    @Autowired
    private UserGoalRepository userGoalsMappingRepository;

    public UserGoalEntity saveUserGoalsMapping(UserGoalEntity userGoalsMapping) {
        return userGoalsMappingRepository.save(userGoalsMapping);
    }

    public Optional<UserGoalEntity> getUserGoalsMappingById(Long mappingId) {
        return userGoalsMappingRepository.findById(mappingId);
    }
    public UserGoalEntity getUserGoalsMappingByUserId(Long userId) {
        return userGoalsMappingRepository.findByUserId(userId)
                .orElse(null);
    }
}


