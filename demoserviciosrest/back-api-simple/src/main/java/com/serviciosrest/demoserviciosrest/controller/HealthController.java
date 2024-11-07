package com.serviciosrest.demoserviciosrest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
@RequiredArgsConstructor
public class HealthController {

    @Value("${spring.datasource.username}")
    private String saludar;

    @GetMapping("/health")
    public ResponseEntity<String> metodoGet(){
        log.info("saludos ".concat(saludar));
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}

