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

    @GetMapping("/testCache/{id}")
    public CommonResult testCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
        return new CommonResult().success("操作成功", 200);
    }

    @GetMapping("/testRemoveCache/{id}")
    public CommonResult testRemoveCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.removeCache(id);
        userService.getUserCache(id);
        return new CommonResult().success("操作成功", 200);
    }


//    @GetMapping("/testCollapser")
//    public CommonResult testCollapser() throws ExecutionException, InterruptedException {
//        Future<User> future1 = userService.getUserFuture(1L);
//        Future<User> future2 = userService.getUserFuture(2L);
//        future1.get();
//        future2.get();
//        ThreadUtil.safeSleep(200);
//        Future<User> future3 = userService.getUserFuture(3L);
//        future3.get();
//        return new CommonResult("操作成功", 200);
//    }




}
