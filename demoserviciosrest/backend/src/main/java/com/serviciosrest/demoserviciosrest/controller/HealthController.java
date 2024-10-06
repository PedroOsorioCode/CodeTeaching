package com.serviciosrest.demoserviciosrest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> metodoGet(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}

