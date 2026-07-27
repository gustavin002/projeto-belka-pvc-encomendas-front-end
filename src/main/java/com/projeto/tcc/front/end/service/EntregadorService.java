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

    public EntregaDTO buscarEntrega(Integer idEntrega) {
        return restClient.get()
            .uri("/entregadores/entregas/" + idEntrega)
            .retrieve()
            .body(EntregaDTO.class);
    }

    public EncomendaDTO atualizarStatus(Integer idEntrega, String novoStatus) {
        return restClient.put()
            .uri("/entregadores/entregas/{idEntrega}/status?novoStatus={novoStatus}", idEntrega, novoStatus)
            .retrieve()
            .body(EncomendaDTO.class);
}

    public EncomendaDTO atualizarLocalAtual(Integer idEntrega, String novoLocal) {
        return restClient.put()
            .uri("/entregadores/entregas/{idEntrega}/local?novoLocal={novoLocal}", idEntrega, novoLocal)
            .retrieve()
            .body(EncomendaDTO.class);
}

    public EntregaDTO validarOTP(Integer idEntrega, String otpDigitado) {
        return restClient.post()
            .uri("/entregadores/entregas/{idEntrega}/validar-otp?otpDigitado={otpDigitado}", idEntrega, otpDigitado)
            .retrieve()
            .body(EntregaDTO.class);
    }

}