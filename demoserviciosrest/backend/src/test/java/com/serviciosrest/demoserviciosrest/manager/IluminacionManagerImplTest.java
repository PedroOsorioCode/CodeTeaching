package com.serviciosrest.demoserviciosrest.manager;

import com.serviciosrest.demoserviciosrest.entities.CasaEntity;
import com.serviciosrest.demoserviciosrest.entities.DispositivoEntity;
import com.serviciosrest.demoserviciosrest.entities.HabitacionEntity;
import com.serviciosrest.demoserviciosrest.repository.DispositivoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class IluminacionManagerImplTest {
    @InjectMocks private IluminacionManagerImpl iluminacionManager;
    @Mock private DispositivoRepository dispositivoRepository;

    @Test
    public void testValidarFuncionalidad(){
        given(dispositivoRepository.findAll()).willReturn(this.crearDispositivos());
        var rs = iluminacionManager.consultar();
        assertNotNull(rs);
        assertFalse(rs.isEmpty());
    }

    private List<DispositivoEntity> crearDispositivos(){
        CasaEntity casa = new CasaEntity();
        casa.setNombre("A");
        HabitacionEntity habitacion = new HabitacionEntity();
        habitacion.setCasa(casa);
        DispositivoEntity dispositivo = new DispositivoEntity();
        dispositivo.setHabitacion(habitacion);
        dispositivo.setEstado(true);
        return List.of(dispositivo);
    }

}
