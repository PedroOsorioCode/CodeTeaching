package com.serviciosrest.demoserviciosrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDto {
    private String tipo;
    private List<DispositivoDto> dispositivos;
}
