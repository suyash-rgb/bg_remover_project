package com.example.removebg.controller;

import com.example.removebg.dto.UserDTO;
import com.example.removebg.response.RemoveBgResponse;
import com.example.removebg.service.IUserService;
import com.example.removebg.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public RemoveBgResponse createOrUpdateUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.saveUser(userDTO);
        return RemoveBgResponse.builder()
                .success(true)
                .data(user)
                .statusCode(HttpStatus.CREATED)
                .build();


    }

}
