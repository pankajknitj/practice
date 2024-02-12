package com.example.bilota.service;

import com.example.bilota.exception.UserNotFoundException;
import com.example.bilota.model.Userr;

import java.util.List;

public interface UserService {
    List<Userr> getUsers();
    Userr saveUser(Userr user);
    Userr getUserById(int id) throws UserNotFoundException;
    int updateUser(Userr user);
}
