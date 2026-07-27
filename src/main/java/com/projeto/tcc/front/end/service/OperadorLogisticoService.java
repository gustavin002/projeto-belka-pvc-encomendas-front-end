/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;


import com.projeto.tcc.front.end.model.ClienteDTO;
import com.projeto.tcc.front.end.model.EncomendaDTO;
import com.projeto.tcc.front.end.model.EntregaDTO;
import com.projeto.tcc.front.end.model.EntregadorDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OperadorLogisticoService {

    private final RestClient restClient;

    public OperadorLogisticoService() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:9000")
            .build();
    }

    public EncomendaDTO cadastrarEncomenda(String token, ClienteDTO clienteRequest) {
        return restClient.post()
            .uri("/operadores-logisticos/cadastrar-encomenda")
            .header("Authorization", "Bearer " + token)
            .body(clienteRequest)
            .retrieve()
            .body(EncomendaDTO.class);
    }
    
    public List<EntregadorDTO> listarEntregadoresDisponiveis() {
        EntregadorDTO[] entregadores = restClient.get()
            .uri("/operadores-logisticos/entregadores-disponiveis")
            .retrieve()
            .body(EntregadorDTO[].class);
        return Arrays.asList(entregadores);
    }
    
    public EntregaDTO escolherEntregador(Integer idEncomenda, Integer idEntregador) {
        return restClient.post()
            .uri("/operadores-logisticos?idEncomenda={idEncomenda}&idEntregador={idEntregador}", idEncomenda, idEntregador)
            .retrieve()
            .body(EntregaDTO.class);
    }

}