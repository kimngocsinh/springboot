package com.springboot.WebAPI.service.impl;


import com.springboot.WebAPI.dto.UserRequest;
import com.springboot.WebAPI.model.Users;
import com.springboot.WebAPI.repository.UsersRepository;
import com.springboot.WebAPI.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepo;


    @Override
    public Users login(UserRequest userRequest) {

        return usersRepo.findByUsernameAndPassword(userRequest.getUsername(),userRequest.getPassword());
    }

    @Override
    public Users register(Users user) {
        if(usersRepo.existsByUsername(user.getUsername())){
            return null;
        }
        user.setRole("admin");
        return usersRepo.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        return usersRepo.findById(id).orElse(null);
    }
}
