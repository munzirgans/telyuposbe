/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.Toko;
import com.pos.models.responses.ResponseJSON;
import com.pos.services.TokoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/toko")
public class TokoController {
    private final TokoServices tokoServices;
    public TokoController(TokoServices tokoServices){
        this.tokoServices = tokoServices;
    }
    
    @GetMapping
    public Toko getToko(){
        return tokoServices.getToko();
    }
    
    @PutMapping
    public ResponseEntity<ResponseJSON> updateToko(@RequestBody Toko toko){
        Toko store = tokoServices.update(toko);
        if(store != null){
            return ResponseEntity.ok(new ResponseJSON("Berhasil update data!"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJSON("Bermasalah pada server!"));
        }
    }
    
    
}
