package com.springboot.WebAPI.controller;


import com.springboot.WebAPI.dto.UserRequest;
import com.springboot.WebAPI.model.Users;
import com.springboot.WebAPI.service.impl.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UsersServiceImpl usersService;
    @PostMapping("/login")
    @CrossOrigin
    ResponseEntity<Users> login(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(usersService.login(userRequest));
    }
    @PostMapping("/register")
    @CrossOrigin
    ResponseEntity<Users> register(@RequestBody Users users){
        return ResponseEntity.ok().body(usersService.register(users));
    }

}
