//package com.example.bilota.model;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/actuator")
//public class LoggedUsersStatisticsEndPoint {
//
//    static Set<String> users = new HashSet<>();
//
//    @GetMapping("/users/")
//    String getLoggedUser(){
//        return "Number of logged users: " + users.size();
//    }
//
//    @GetMapping("/users/{name}")
//    String getUserByName(@PathVariable("name") String name){
//        if(users.contains(name)){
//            return name + " is logged";
//        }
//        return name + " is not logged";
//    }
//
//    @PostMapping("/users/")
//    void logUser(@RequestBody UserRequest user){
//        users.add(user.userName);
//    }
//
//    @DeleteMapping("/users/{name}")
//    void loggedOut(@PathVariable("name") String name){
//        users.remove(name);
//    }
//
//    @DeleteMapping("/users/")
//    void loggedAllUsers(){
//        users.clear();
//    }
//
//    class UserRequest{
//        String userName;
//    }
//
//}
