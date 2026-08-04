/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.service;

import com.projeto.tcc.front.end.model.UserRequestDTO;
import com.projeto.tcc.front.end.model.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UsuarioService {

    private final RestClient restClient;

    public UsuarioService() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:9000")
            .build();
    }

    public String login(UserRequestDTO request) {
        return restClient.post()
            .uri("/usuarios/login")
            .body(request)
            .retrieve()
            .body(String.class);
    }

    public UsuarioDTO buscarUsuarioLogado(String token) {
        UsuarioDTO usuario = restClient.get()               
            .uri("/usuarios/me")
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .body(UsuarioDTO.class);
        
        System.out.println(usuario.getIdUsuario());
        System.out.println(usuario.getNomeUsuario());
        System.out.println(usuario.getEmailUsuario());
        System.out.println(usuario.getSenhaUsuario());
        System.out.println(usuario.getRoleUsuario());
        System.out.println(usuario.getDisponibilidadeUsuario());
        
        return usuario;  
    }
    
}