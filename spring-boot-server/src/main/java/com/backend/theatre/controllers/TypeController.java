package com.backend.theatre.controllers;

import com.backend.theatre.models.Type;
import com.backend.theatre.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/type/add")
    public ResponseEntity<Type> addType(@Valid @RequestBody Type type){
        return ResponseEntity.ok(typeService.saveType(type));
    }

    @GetMapping("/type/get")
    public List<Type> get(){
        return typeService.getTypes();
    }

}
