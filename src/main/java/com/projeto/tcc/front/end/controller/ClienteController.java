/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.model.EncomendaDTO;
import com.projeto.tcc.front.end.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/rastreio")
    public String rastrear(@RequestParam(required = false) String codigo, Model model) {

        if (codigo == null || codigo.isEmpty()) {
            model.addAttribute("erroRastreio", "Digite um código de rastreio");
            return "index";
        }

        try {
            EncomendaDTO encomenda = clienteService.rastrearEncomenda(codigo);
            model.addAttribute("encomenda", encomenda);
            return "minhaencomenda";

        } catch (Exception e) {
            model.addAttribute("erroRastreio", "Código de rastreio incorreto");
            return "index";
        }
        
    }

}