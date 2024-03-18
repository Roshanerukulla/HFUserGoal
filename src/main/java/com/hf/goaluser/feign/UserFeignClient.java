package com.hf.goaluser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hf.goaluser.response.UserResponse;

@FeignClient(name = "HFUSER1", url = "http://localhost:8081")
public interface UserFeignClient {

	 @GetMapping("/api/users/{userId}")
	    UserResponse getUser(@PathVariable Long userId);
}
