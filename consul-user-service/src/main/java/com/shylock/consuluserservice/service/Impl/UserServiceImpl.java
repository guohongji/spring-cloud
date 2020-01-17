package com.shylock.consuluserservice.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.shylock.consuluserservice.bean.User;
import com.shylock.consuluserservice.common.CommonResult;
import com.shylock.consuluserservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void create(User user) {
        System.out.println("create");
    }

    @Override
    public User getByUsername(String username) {
        User user = new User();
        return user;
    }

    @Override
    public void update(User user) {
        System.out.println("update");
    }

    @Override
    public void delete(Long id) {
        System.out.println("delete");
    }

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setUsername("getUser:"+id);
        return user;
    }

    @Override
    public List<User> getUserByIds(List<Long> ids) {
        List list = new ArrayList();
        User user = new User();
        list.add(user);
        return list;
    }

    public Object getDefaultUser(@PathVariable Long id) {
        User defaultUser = new User();
        defaultUser.setUsername("shylock--default");
        return new CommonResult().success(defaultUser);
    }

}
