//package com.example.bilota.model;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequestMapping("/actuator")
//public class GuestStattisticsEndPoint {
//    static long guest = 0L;
//
//    @GetMapping("/guests/")
//    ResponseEntity<?> getCheckedGuest(){
//        return new ResponseEntity<>("Number of guests: " + guest, HttpStatus.OK);
//    }
//
//    @PostMapping("/guests/")
//    void CheckGuest(){
//        guest += 1L;
//    }
//    @DeleteMapping("/guests/")
//    void deleteGuest(){
//        guest = 0L;
//    }
//}
