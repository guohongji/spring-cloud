package com.shylock.hystrixservice.controller;

import com.shylock.hystrixservice.service.UserService;
import com.shylock.userservice.common.CommonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class UserHystrixController {

    @Autowired
    private UserService userService;


    @GetMapping("/testFallback/{id}")
    public Object testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }




}
