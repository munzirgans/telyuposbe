/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.controllers;

import com.pos.models.entities.IncomingReport;
import com.pos.services.IncomingReportServices;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/report/incoming")
public class IncomingReportController {
    private final IncomingReportServices incomingReportServices;
    public IncomingReportController(IncomingReportServices incomingReportServices){
        this.incomingReportServices = incomingReportServices;
    }
    @GetMapping
    public List<IncomingReport> getAllIncomingReport(){
        return incomingReportServices.getAllIncomingReport();
    }
}
