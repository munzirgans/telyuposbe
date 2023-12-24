/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.Users;
import com.pos.models.responses.ResponseJSON;
import com.pos.services.UserServices;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserServices userServices;

    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }
    
    @GetMapping
    public List<Users> getAllUsers(){
        return userServices.findAll();
    }
    
    @PostMapping
    public Users save(@RequestBody Users users){
        return userServices.save(users);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseJSON> delete(@PathVariable Long id){
        Users user = userServices.delete(id);
        if(user != null){
            return ResponseEntity.ok(new ResponseJSON("Berhasil hapus user!"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJSON("Tidak dapat menghapus user!"));
        }
    }
    
}
