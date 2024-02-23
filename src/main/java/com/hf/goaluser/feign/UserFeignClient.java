package com.hf.goaluser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HFUSER1", url = "http://localhost:8081")
public interface UserFeignClient {

    @GetMapping("/api/users/{userId}")
    String getUser(@PathVariable Long userId);
}
