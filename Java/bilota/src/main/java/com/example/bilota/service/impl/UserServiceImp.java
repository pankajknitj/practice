package com.example.bilota.service.impl;

import com.example.bilota.exception.UserNotFoundException;
import com.example.bilota.model.Userr;
import com.example.bilota.repo.UserRepository;
import com.example.bilota.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Userr> getUsers() {
        return userRepo.findUser();
    }

    @Override
    public Userr saveUser(Userr user) {
        return userRepo.save(user);
    }

    @Override
    public Userr getUserById(int id) throws UserNotFoundException {
        Optional<Userr> userOptional = userRepo.findById(id);
        Userr user = null;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new UserNotFoundException("User is not present in database");
        }
        return user;
    }

    @Override
    @Transactional
    public int updateUser(Userr user) {
        return userRepo.updateUser(user.getName(), Arrays.asList(user.getId()));
    }
}
