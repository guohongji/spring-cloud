package com.shylock.userservice.service;

import com.shylock.userservice.bean.User;

import java.util.List;

public interface UserService {
    void create(User user);

    User getByUsername(String username);

    void update(User user);

    void delete(Long id);

    User getUser(Long id);

    List<User> getUserByIds(List<Long> ids);
}
