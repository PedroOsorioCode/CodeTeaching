package com.serviciosrest.demoserviciosrest.controller;

import com.serviciosrest.demoserviciosrest.dto.CasaDto;
import com.serviciosrest.demoserviciosrest.dto.IluminacionHogarDTO;
import com.serviciosrest.demoserviciosrest.manager.IluminacionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarCasaHabitacion(@RequestBody CasaDto casaDto){
        iluminacionManager.guardarCasa(casaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}