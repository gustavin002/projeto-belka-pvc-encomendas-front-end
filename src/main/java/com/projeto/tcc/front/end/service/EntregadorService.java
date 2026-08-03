/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;

import com.projeto.tcc.front.end.model.EncomendaDTO;
import com.projeto.tcc.front.end.model.EntregaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EntregadorService {

    private final RestClient restClient;

    public EntregadorService() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:9000")
            .build();
    }

    public EntregaDTO verEntrega(Integer idEntrega, String token) {
        return restClient.get()
            .uri("/entregadores/entregas/" + idEntrega)
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EntregaDTO.class);
    }

    public EncomendaDTO atualizarStatus(Integer idEntrega, String token, String novoStatus) {
        return restClient.put()
            .uri("/entregadores/entregas/{idEntrega}/status?novoStatus={novoStatus}", idEntrega, novoStatus)
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EncomendaDTO.class);
    }

    public EncomendaDTO atualizarLocalAtual(Integer idEntrega, String token, String novoLocal) {
        return restClient.put()
            .uri("/entregadores/entregas/{idEntrega}/local?novoLocal={novoLocal}", idEntrega, novoLocal)
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EncomendaDTO.class);
    }

    public EntregaDTO validarOTP(Integer idEntrega, String token, String otpDigitado) {
        return restClient.post()
            .uri("/entregadores/entregas/{idEntrega}/validar-otp?otpDigitado={otpDigitado}", idEntrega, otpDigitado)
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(EntregaDTO.class);
    }

}