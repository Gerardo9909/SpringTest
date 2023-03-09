package com.exam.springtest.controller;

import com.exam.springtest.model.User;
import com.exam.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        if (userService.saveUser(user) != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
    }

    @PutMapping
    public ResponseEntity<Object> modifyUser(@RequestBody User user) {
        if (userService.modifyUser(user) != null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist");
        }
    }
}
