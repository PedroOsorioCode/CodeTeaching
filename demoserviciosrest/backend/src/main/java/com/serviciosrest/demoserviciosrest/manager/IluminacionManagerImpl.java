package com.serviciosrest.demoserviciosrest.manager;

import com.serviciosrest.demoserviciosrest.IluminacionHogarDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class IluminacionManagerImpl implements IluminacionManager {

    @Override
    public List<IluminacionHogarDTO> consultar() {
        return List.of(
            new IluminacionHogarDTO("A001", "Sala", true),
            new IluminacionHogarDTO("A001", "Comedor", false),
            new IluminacionHogarDTO("A002", "Sala", true)
        );
    }

}