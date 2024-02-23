package com.hf.goaluser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hf.goaluser.entity.UserGoalEntity;

import java.util.List;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoalEntity, Long> {

    UserGoalEntity findByUserId(Long userId);
}

