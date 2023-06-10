package com.springboot.WebAPI.service;


import com.springboot.WebAPI.dto.UserRequest;
import com.springboot.WebAPI.model.Users;

public interface UsersService {
    Users login(UserRequest userRequest);
    Users register(Users user);

    Users getUserById(Long id);

}
