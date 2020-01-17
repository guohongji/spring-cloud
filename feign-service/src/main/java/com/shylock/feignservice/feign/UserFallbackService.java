package com.shylock.feignservice.feign;

import com.shylock.userservice.bean.User;
import com.shylock.userservice.common.CommonResult;
import org.springframework.stereotype.Component;

/**
 * Created by macro on 2019/9/5.
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public Object create(User user) {
        User defaultUser = new User();
        defaultUser.setUsername("create;;;feign");
        return new CommonResult().success(defaultUser);
    }

    @Override
    public Object getUser(Long id) {
        User defaultUser = new User();
        defaultUser.setUsername("getUser;;;feign");
        return new CommonResult().success(defaultUser);
    }

    @Override
    public Object getByUsername(String username) {
        User defaultUser = new User();
        defaultUser.setUsername("getByUsername;;;feign");
        return new CommonResult().success(defaultUser);
    }

    @Override
    public Object update(User user) {
        return new CommonResult().failed("调用失败，服务被降级");
    }

    @Override
    public Object delete(Long id) {
        return new CommonResult().failed("调用失败，服务被降级");
    }
}
