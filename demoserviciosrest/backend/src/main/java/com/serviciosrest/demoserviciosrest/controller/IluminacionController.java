package com.serviciosrest.demoserviciosrest.controller;

import com.serviciosrest.demoserviciosrest.IluminacionHogarDTO;
import com.serviciosrest.demoserviciosrest.manager.IluminacionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/iluminacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class IluminacionController {
    private final IluminacionManager iluminacionManager;

    @GetMapping("/consultar")
    public ResponseEntity<List<IluminacionHogarDTO>> obtenerEstadoIluminacion() {
        return new ResponseEntity<>(iluminacionManager.consultar(), HttpStatus.OK);
    }
}