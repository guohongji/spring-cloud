package com.shylock.consuluserservice.controller;


import com.shylock.consuluserservice.bean.User;
import com.shylock.consuluserservice.common.CommonResult;
import com.shylock.consuluserservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by macro on 2019/8/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        userService.create(user);
        return new CommonResult().success("操作成功");
    }

    @GetMapping("/{id}")
    public Object getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        LOGGER.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
        return new CommonResult().success(user);
    }

    @GetMapping("/getUserByIds")
    public Object getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList= userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}",userList);
        return new CommonResult().success(userList);
    }

    @GetMapping("/getByUsername")
    public Object getByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return new CommonResult().success(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        userService.update(user);
        return new CommonResult().success("ok");
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        userService.delete(id);
        return new CommonResult().success("操作成功");
    }
}

