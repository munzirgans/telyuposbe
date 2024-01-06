/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.services;

import com.pos.models.entities.IncomingReport;
import com.pos.models.repos.IncomingReportRepo;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class IncomingReportServices {
    private final IncomingReportRepo incomingReportRepo;
    public IncomingReportServices(IncomingReportRepo incomingReportRepo){
        this.incomingReportRepo = incomingReportRepo;
    }
    
    public IncomingReport save(IncomingReport incomingReport ){
        return incomingReportRepo.save(incomingReport);
    }
    
    public List<IncomingReport> getAllIncomingReport(){
        return incomingReportRepo.findAll();
    }
    public Long getCount(){
        return incomingReportRepo.count();
    }
    
}
