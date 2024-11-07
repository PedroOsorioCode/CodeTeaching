package com.serviciosrest.demoserviciosrest.manager;

import com.serviciosrest.demoserviciosrest.dto.IluminacionHogarDTO;
import com.serviciosrest.demoserviciosrest.entities.DispositivoEntity;
import com.serviciosrest.demoserviciosrest.repository.DispositivoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class IluminacionManagerImpl implements IluminacionManager {
    private final DispositivoRepository dispositivoRepository;

    @Override
    public List<IluminacionHogarDTO> consultar() {
        List<DispositivoEntity> listaDispositivos = dispositivoRepository.findAll();

        return listaDispositivos.stream()
            .map(data -> new IluminacionHogarDTO(
                    data.getHabitacion().getCasa().getNombre(),
                    data.getHabitacion().getTipo(),
                    data.getTipo(),
                    data.getEstado()
            )).toList();
    }

}