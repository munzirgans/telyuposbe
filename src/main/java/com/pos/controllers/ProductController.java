/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.Products;
import com.pos.models.responses.ResponseJSON;
import com.pos.services.ProductServices;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServices productService;

    public ProductController(ProductServices productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable Long id){
        return productService.findById(id);
    }
    @GetMapping
    public List<Products> getAllProducts(){
        return productService.findAll();
    }
    
    @PostMapping
    public Products save(@RequestBody Products products){
        return productService.save(products);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseJSON> update(@PathVariable Long id, @RequestBody Products products){
        Products product = productService.update(id, products);
        if(product != null){
            return ResponseEntity.ok(new ResponseJSON("Berhasil update data!"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJSON("Ada yang bermasalah pada internal server error!"));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseJSON> delete(@PathVariable Long id){
        Products product = productService.delete(id);
        if(product != null){
            return ResponseEntity.ok(new ResponseJSON("Berhasil hapus data!"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJSON("Ada yang bermasalah pada internal server error!"));
        }
    }
    
    @PutMapping("/stock/{id}")
    public ResponseEntity<Products> updateStock(@PathVariable Long id, @RequestBody Products products){
        Products product = productService.updateStock(id,products.getStock());
        if(product != null){
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

