package com.example.removebg.service;

import com.example.removebg.dto.UserDTO;
import com.fasterxml.jackson.databind.JsonNode;

public interface IUserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO getUserByClerkId(String clerkId);

    void deleteUserByClerkId(String clerkId);
}
