/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;


import com.projeto.tcc.front.end.model.EntregaDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EntregaService {

    private final RestClient restClient;

    public EntregaService() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:9000")
            .build();
    }

    public List<EntregaDTO> listarEntregasDoEntregador(String token) {
        EntregaDTO[] entregas = restClient.get()
            .uri("/entregas/minhas-entregas")
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EntregaDTO[].class);

        return Arrays.asList(entregas);
    }

}