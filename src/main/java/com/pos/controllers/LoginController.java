/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.Users;
import com.pos.models.responses.ResponseJSON;
import com.pos.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final UserServices userService;
    @Autowired
//    private UserServices userService;

    public LoginController(UserServices userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Users> login(@RequestBody Users users){
        Users user = userService.findByEmail(users.getEmail());
        if(user != null && users.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
