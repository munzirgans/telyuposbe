/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.services;

import com.pos.models.entities.Products;
import com.pos.models.repos.ProductRepo;
import com.pos.models.responses.ResponseJSON;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Asus
 */
@Service
public class ProductServices {
    private final ProductRepo productRepo;

    public ProductServices(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    
    public Products findById(Long id){
        return productRepo.findById(id).orElse(null);
    }
    
    public List<Products> findAll(){
        return productRepo.findAll();
    }
    
    public Products save(Products products){
        return productRepo.save(products);
    }
    
    public Products update(Long id, Products products){
        Products product = productRepo.findById(id).orElse(null);
        if(product != null){
            product.setName(products.getName());
            product.setPurchase_price(products.getPurchase_price());
            product.setBarcode(products.getBarcode());
            product.setSelling_price(products.getSelling_price());
            product.setStock(products.getStock());
            productRepo.save(product);
            return product;
        }else{
            return null;
        }
    }
    
    public Products delete(Long id){
        Products product = productRepo.findById(id).orElse(null);
        if(product != null){
            productRepo.deleteById(id);
            return product;
        }else{
            return null;
        }
    }
    
    public Products updateStock(Long id, int stock){
        Products product = productRepo.findById(id).orElse(null);
        if(product != null){
            product.setStock(stock);
            productRepo.save(product);
        }
        return product;
        
    }
}
