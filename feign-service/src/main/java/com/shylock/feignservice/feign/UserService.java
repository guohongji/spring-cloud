package com.shylock.feignservice.feign;


import com.shylock.userservice.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by macro on 2019/9/5.
 */
@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserService {
    @PostMapping("/user/create")
    Object create(@RequestBody User user);

    @GetMapping("/user/{id}")
    Object getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    Object getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    Object update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    Object delete(@PathVariable Long id);
}

