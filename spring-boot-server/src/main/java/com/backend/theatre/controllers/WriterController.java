package com.backend.theatre.controllers;

import com.backend.theatre.models.Writer;
import com.backend.theatre.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/writer")
public class WriterController {

    @Autowired
    private WriterRepository writerRepository;

    @PostMapping("/add")
    public Writer addWriter(@Valid @RequestBody Writer writer){
        return writerRepository.save(writer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Writer>> getAllWriters(){
        List<Writer> writers =  writerRepository.findAll();
        return new ResponseEntity<>(writers, HttpStatus.OK);
    }
}
