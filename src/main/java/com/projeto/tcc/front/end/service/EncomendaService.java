/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;

import com.projeto.tcc.front.end.model.EncomendaDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EncomendaService {

    private final RestClient restClient;

    public EncomendaService() {
        this.restClient = RestClient.builder().baseUrl("http://localhost:9000").build();
    }

    public List<EncomendaDTO> listarEncomendasPorOperador(String token, Integer idOperador) {
        EncomendaDTO[] encomendas = restClient.get()
            .uri("/encomendas/operador" + idOperador)
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EncomendaDTO[].class);

        return Arrays.asList(encomendas);
    }

    public List<EncomendaDTO> listarEncomendasPorCliente(String token, Integer idCliente) {
        EncomendaDTO[] encomendas = restClient.get()
            .uri("/encomendas/cliente/" + idCliente)
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EncomendaDTO[].class);

        return Arrays.asList(encomendas);
    }

}