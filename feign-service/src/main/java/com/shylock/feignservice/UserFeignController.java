package com.shylock.feignservice;

import com.shylock.feignservice.feign.UserService;
import com.shylock.userservice.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by macro on 2019/8/29.
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Object getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public Object getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public Object create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public Object update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public Object delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
