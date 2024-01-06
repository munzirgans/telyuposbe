/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.Products;
import com.pos.models.entities.Toko;
import com.pos.services.ProductServices;
import com.pos.services.TokoServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/pos")
public class PosController {
    private final ProductServices productServices;
    private final TokoServices tokoServices;
    public PosController(ProductServices productServices, TokoServices tokoServices){
        this.productServices = productServices;
        this.tokoServices = tokoServices;
    }
    
    private List<Products> getAllProduct(){
        return productServices.findAll();
    }
    
    private Toko getToko(){
        return tokoServices.getToko();
    }
    
    @GetMapping
    public Map<String, Object> getPos(){
        Toko toko = this.getToko();
        List<Products> productList = this.getAllProduct();
        Map<String, Object> result = new HashMap<>();
        result.put("toko", toko);
        result.put("products", productList);
        return result;
    }
}
