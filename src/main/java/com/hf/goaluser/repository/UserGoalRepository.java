package com.hf.goaluser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hf.goaluser.entity.UserGoalEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoalEntity, Long> {

    Optional<UserGoalEntity> findByUserId(Long userId);
}

