/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;

import com.projeto.tcc.front.end.model.AdminDTO;
import com.projeto.tcc.front.end.model.EntregadorDTO;
import com.projeto.tcc.front.end.model.OperadorLogisticoDTO;
import com.projeto.tcc.front.end.model.UserRequestDTO;
import com.projeto.tcc.front.end.model.UsuarioDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AdminService {

    private final RestClient restClient;

    public AdminService() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:9000")
            .build();
    }

    public String login(UserRequestDTO request) {
        return restClient.post()
            .uri("/admin/login")
            .body(request)
            .retrieve()
            .body(String.class);
    }
    
    public AdminDTO buscarAdminLogado(String token) {
        return restClient.get()
            .uri("/admin/me")
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(AdminDTO.class);
    }

    public EntregadorDTO cadastrarEntregador(UsuarioDTO usuario) {
        return restClient.post()
            .uri("/admin/entregadores")
            .body(usuario)
            .retrieve()
            .body(EntregadorDTO.class);
    }

    public OperadorLogisticoDTO cadastrarOperadorLogistico(UsuarioDTO usuario) {
        return restClient.post()
            .uri("/admin/operadores-logisticos")
            .body(usuario)
            .retrieve()
            .body(OperadorLogisticoDTO.class);
    }

    public List<EntregadorDTO> listarEntregadores() {
        EntregadorDTO[] entregadores = restClient.get()
            .uri("/admin/entregadores")
            .retrieve()
            .body(EntregadorDTO[].class);

        return Arrays.asList(entregadores);
    }

    public List<OperadorLogisticoDTO> listarOperadoresLogisticos() {
        OperadorLogisticoDTO[] operadores = restClient.get()
                .uri("/admin/operadores-logisticos")
                .retrieve()
                .body(OperadorLogisticoDTO[].class);

        return Arrays.asList(operadores);
    }

}