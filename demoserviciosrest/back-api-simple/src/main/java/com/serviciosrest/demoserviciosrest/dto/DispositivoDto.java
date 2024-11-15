package com.serviciosrest.demoserviciosrest.dto;

import com.serviciosrest.demoserviciosrest.entities.HabitacionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDto {
    private HabitacionEntity habitacion;
    private String tipo;
    private Boolean estado;
}
