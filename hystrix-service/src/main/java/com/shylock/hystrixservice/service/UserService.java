package com.shylock.hystrixservice.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {



    public Object getUser(Long id);

    public Object getDefaultUser(@PathVariable Long id);



}
