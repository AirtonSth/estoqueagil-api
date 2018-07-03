package com.aplicacao.estoqueagil.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ModeloControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
 
    @Test
    public void getAllModelos() throws Exception {
        mockMvc.perform(get("/modelos/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void getModeloById() throws Exception {
        mockMvc.perform(get("/modelos/por-id/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void getModeloByIdMarca() throws Exception {
        mockMvc.perform(get("/modelos/por-id-marca/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}