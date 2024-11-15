package com.serviciosrest.demoserviciosrest.manager;

import com.serviciosrest.demoserviciosrest.dto.CasaDto;
import com.serviciosrest.demoserviciosrest.dto.HabitacionDto;
import com.serviciosrest.demoserviciosrest.dto.IluminacionHogarDTO;
import com.serviciosrest.demoserviciosrest.entities.CasaEntity;
import com.serviciosrest.demoserviciosrest.entities.DispositivoEntity;
import com.serviciosrest.demoserviciosrest.entities.HabitacionEntity;
import com.serviciosrest.demoserviciosrest.repository.CasaRepository;
import com.serviciosrest.demoserviciosrest.repository.DispositivoRepository;
import com.serviciosrest.demoserviciosrest.repository.HabitacionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IluminacionManagerImpl implements IluminacionManager {
    private final DispositivoRepository dispositivoRepository;
    private final CasaRepository casaRepository;
    private final HabitacionRepository habitacionRepository;

    @Override
    public List<IluminacionHogarDTO> consultar() {
        log.info("Ejecutando consulta");
        List<DispositivoEntity> listaDispositivos = dispositivoRepository.findAll();

        return listaDispositivos.stream()
            .map(data -> new IluminacionHogarDTO(
                    data.getHabitacion().getCasa().getNombre(),
                    data.getHabitacion().getTipo(),
                    data.getTipo(),
                    data.getEstado()
            )).toList();
    }

    @Override
    public void guardarCasa(CasaDto casaDto) {
        CasaEntity casaSaved = casaRepository.save(new CasaEntity(casaDto.getNombre()));
        List<HabitacionEntity> habitaciones = casaDto.getHabitaciones().stream().map(data ->
           new HabitacionEntity(data.getTipo(), casaSaved)
        ).toList();
        List<HabitacionEntity> listaHabitaciones = habitacionRepository.saveAll(habitaciones);
        listaHabitaciones.stream().forEach(data -> {
            casaDto.getHabitaciones().stream().forEach(habitacion -> {
                List<DispositivoEntity> listaDispositivos = habitacion.getDispositivos().stream().map(e->
                    new DispositivoEntity(e.getTipo(), e.getEstado(), data)
                ).toList();

                dispositivoRepository.saveAll(listaDispositivos);
            });
        });
    }

}