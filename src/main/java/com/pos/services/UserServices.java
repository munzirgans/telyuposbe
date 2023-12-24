/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.services;

import com.pos.models.repos.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.pos.models.entities.Users;
import java.util.List;

/**
 *
 * @author Asus
 */
@Service
@Transactional
public class UserServices {
    private final UserRepo userRepo;

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    public Users findByEmail(String email){
        return userRepo.findByEmail(email);
    }
    
    public List<Users> findAll(){
        return userRepo.findAll();
    }
    
    public Users save(Users users){
        return userRepo.save(users);
    }
    
    public Users delete(Long id){
        Users user = userRepo.findById(id).orElse(null);
        if(user != null){
            userRepo.deleteById(id);
            return user;
        }else{
            return null;
        }
    }
}
