package com.serviciosrest.demoserviciosrest.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class IluminacionManagerImplTest {
    @InjectMocks private IluminacionManagerImpl iluminacionManager;

    @Test
    public void testValidarFuncionalidad(){
        var rs = iluminacionManager.consultar();
        assertNotNull(rs);
        assertFalse(rs.isEmpty());
    }

}
