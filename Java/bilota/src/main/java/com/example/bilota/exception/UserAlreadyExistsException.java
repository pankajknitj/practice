package com.example.bilota.exception;

import lombok.Data;

@Data
public class UserAlreadyExistsException extends RuntimeException{
    String message;
}
