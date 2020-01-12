package com.shylock.hystrixservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shylock.hystrixservice.service.UserService;
import com.shylock.userservice.bean.User;
import com.shylock.userservice.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @Override
    public Object getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    @Override
    public Object getDefaultUser(@PathVariable Long id) {
        User defaultUser = new User();
        defaultUser.setUsername("shylock--default");
        return new CommonResult().success(defaultUser);
    }

}
