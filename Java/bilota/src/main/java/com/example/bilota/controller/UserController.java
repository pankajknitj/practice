package com.example.bilota.controller;

import com.example.bilota.model.Userr;
import com.example.bilota.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> userData(){
        List<Userr> userList = userService.getUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> userData(@PathVariable("id") int id) throws Exception {
        Userr user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save/user")
    public Userr save(@RequestBody Userr user){
        return userService.saveUser(user);
    }

    @PutMapping("/update/user")
    public int updateUser(@RequestBody Userr user){
        return userService.updateUser(user);
    }



}
