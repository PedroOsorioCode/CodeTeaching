package com.serviciosrest.demoserviciosrest.controller;

import com.serviciosrest.demoserviciosrest.IluminacionHogarDTO;
import com.serviciosrest.demoserviciosrest.manager.IluminacionManagerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IluminacionController.class)
class IluminacionControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private IluminacionManagerImpl iluminacionManager;

    @Test
    void testConsultarIluminacionHogar() throws Exception {
        given(iluminacionManager.consultar()).willReturn(List.of(new IluminacionHogarDTO()));
        this.mockMvc.perform(get("/api/iluminacion/consultar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(iluminacionManager).consultar();
    }
}
