package com.serviciosrest.demoserviciosrest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IluminacionHogarDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7167762692330801803L;

    private String casa;
    private String cuarto;
    private boolean estado;
}