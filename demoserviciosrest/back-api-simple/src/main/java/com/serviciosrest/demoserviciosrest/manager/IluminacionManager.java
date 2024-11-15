package com.serviciosrest.demoserviciosrest.manager;

import com.serviciosrest.demoserviciosrest.dto.CasaDto;
import com.serviciosrest.demoserviciosrest.dto.IluminacionHogarDTO;

import java.util.List;

/*
 * Servicio para obtener el estado de iluminación de un hogar
 */
public interface IluminacionManager {
    /*
     * Documente
     */
    List<IluminacionHogarDTO> consultar();
    void guardarCasa(CasaDto casaDto);

}