/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.models.repos;

import com.pos.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Asus
 */
public interface UserRepo extends JpaRepository<Users, Long>{
    Users findByEmail(String email);
}
