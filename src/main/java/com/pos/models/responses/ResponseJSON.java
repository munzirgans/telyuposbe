/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.models.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Asus
 */
@Getter
@Setter
public class ResponseJSON {
    public String message;

    public ResponseJSON(String message) {
        this.message = message;
    }
    
}
