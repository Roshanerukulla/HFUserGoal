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
public class UserGoalServiceImpl implements UserGoalService {

    @Autowired
    private UserGoalRepository userGoalRepository;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private GoalsFeignClient goalsFeignClient;

    @Override
    public UserGoalEntity getUserGoals(Long userId) {
        return userGoalRepository.findByUserId(userId);
    }

    @Override
    public UserGoalEntity addUserGoals(Long userId, Map<String, Long> goals) {
        // Validate if the user exists
        userFeignClient.getUser(userId);

        // Validate if the goals exist
        goals.values().forEach(goalsFeignClient::getGoal);

        // Save or update user goals
        UserGoalEntity userGoalEntity = new UserGoalEntity();
        userGoalEntity.setUserId(userId);
        userGoalEntity.setGoals(goals);
        return userGoalRepository.save(userGoalEntity);
    }

    @Override
    public void deleteUserGoal(Long userId, String goalKey) {
        UserGoalEntity userGoalEntity = userGoalRepository.findByUserId(userId);
        if(userGoalEntity.getGoals().containsKey(goalKey)) {
        	  userGoalEntity.getGoals().remove(goalKey);
              userGoalRepository.save(userGoalEntity);
        
        }
        else  {
        	throw new IllegalArgumentException("User or goal not found");	
        }
            
    }

	@Override
	public UserGoalEntity UpdateUserGoals(Long userId, Map<String, Long> goals, String goalKey) {
		 UserGoalEntity userGoalEntity = userGoalRepository.findByUserId(userId); 
		 if(userGoalEntity.getGoals().containsKey(goalKey)) {
			 Optional<Long> replaceGoal= goals.entrySet().stream().filter(t->t.getKey().equals(goalKey)).findFirst().map(t->t.getValue());
       	  userGoalEntity.getGoals().replace(goalKey, replaceGoal.get());
       	  userGoalRepository.save(userGoalEntity);
       
       }
       else  {
       	throw new IllegalArgumentException("User or goal not found");	
       }
         
	       
		
		return null;
	}
}
