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
public class ProdutoControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
 
    @Test
    public void getAllProdutos() throws Exception {
        mockMvc.perform(get("/produtos/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void getProdutoById() throws Exception {
        mockMvc.perform(get("/produtos/por-id/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void getProdutosByIdModelo() throws Exception {
        mockMvc.perform(get("/produtos/por-id-modelo/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void getProdutosByIdTipoProduto() throws Exception {
        mockMvc.perform(get("/produtos/por-id-tipo-produto/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}