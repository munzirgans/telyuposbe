/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.Products;
import com.pos.services.IncomingReportServices;
import com.pos.services.ProductServices;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private  final ProductServices productServices;
    private final IncomingReportServices incomingReportServices;
    public DashboardController(ProductServices productServices, IncomingReportServices incomingReportServices){
        this.productServices = productServices;
        this.incomingReportServices = incomingReportServices;
    }
    private Long getCountProducts(){
        return productServices.getCountProducts();
    }
    private Long getCountIncomingReports(){
        return incomingReportServices.getCount();
    }
    
    @GetMapping
    public Map<String, Object> getDashboard(){
        Map<String, Object> result = new HashMap<>();
        result.put("products", getCountProducts());
        result.put("incoming", getCountIncomingReports());
        return result;
    }
}
