package com.serviciosrest.demoserviciosrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasaDto {
    private String nombre;
    private List<HabitacionDto> habitaciones;
}
