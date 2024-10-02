package com.serviciosrest.demoserviciosrest.manager;

import com.serviciosrest.demoserviciosrest.IluminacionHogarDTO;

import java.util.List;

/*
 * Servicio para obtener el estado de iluminación de un hogar
 */
public interface IluminacionManager {
    /*
     * Documente
     */
    List<IluminacionHogarDTO> consultar();

}