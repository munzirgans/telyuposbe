/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.services;

import com.pos.models.entities.Toko;
import com.pos.models.repos.TokoRepo;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class TokoServices {
    private final TokoRepo tokoRepo;
    
    public TokoServices(TokoRepo tokoRepo){
        this.tokoRepo = tokoRepo;
    }
    public Toko getToko(){
        Toko toko = tokoRepo.findById(1L).orElse(null);
        if(toko == null){
            Toko newToko = new Toko();
            newToko.setName("Telyu POS");
            newToko.setPhone("08123456789");
            newToko.setAddress("Jl. Raya Bojongsoang");
            toko = tokoRepo.save(newToko);
        }
        return toko;
    }
    
    public Toko update(Toko toko){
        Toko store = tokoRepo.findById(1L).orElse(null);
        if(store != null){
            store.setName(toko.getName());
            store.setPhone(toko.getPhone());
            store.setAddress(toko.getAddress());
            tokoRepo.save(store);
            return store;
        }
        return null;
    }
    
    public Toko delete(Long id){
        Toko toko = tokoRepo.findById(id).orElse(null);
        if(toko != null){
            tokoRepo.deleteById(id);
            return toko;
        }else{
            return null;
        }
    }
}
