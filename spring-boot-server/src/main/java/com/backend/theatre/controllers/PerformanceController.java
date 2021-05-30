package com.backend.theatre.controllers;

import com.backend.theatre.models.Performance;
import com.backend.theatre.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/performances/add")
    public ResponseEntity<Performance> addPerformance(@RequestBody Performance performance){
        return new ResponseEntity<Performance>(performanceService.savePerformance(performance), HttpStatus.CREATED);
    }

    @GetMapping("/performances/all")
    public Page<Performance> getAllPerformances(@RequestParam(defaultValue = "0") int pageNumber,
                                                @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestParam(defaultValue = "ASC") Sort.Direction order){
        return performanceService.getAllPerformance(pageNumber, pageSize, order);
    }
    @GetMapping("/performances/get")
    public List<Performance> getP(){
        return performanceService.getAll();
    }

    @GetMapping("/performances/{id}")
    public Performance getPerformanceById(@PathVariable("id") Long id){
        return performanceService.getById(id).orElse(null);
    }

    @PutMapping("/performances/update")
    public Performance updatePerformance(@RequestBody Performance performance){
        return performanceService.updatePerformance(performance);
    }

    @DeleteMapping("/performances/delete/{id}")
    public void deletePerformanceById(@PathVariable("id") Long id){
        performanceService.deletePerformance(id);
    }


}
