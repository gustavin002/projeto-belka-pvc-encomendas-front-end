/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;

import com.projeto.tcc.front.end.model.EncomendaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClienteService {

    private final RestClient restClient;

    public ClienteService() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:9000")
            .build();
    }

    public EncomendaDTO rastrearEncomenda(String codigoRastreio) {
        return restClient.get()
            .uri("/clientes/rastreio/" + codigoRastreio)
            .retrieve()
            .body(EncomendaDTO.class);
    }

}