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

    @GetMapping("/minha/encomenda")
    public String minhaEncomenda() {
        return "minhaencomenda";
    }
    
    @GetMapping("/rastreio")
    public String rastrear(@RequestParam(required = false) String codigo, Model model) {

        if (codigo != null && !codigo.isEmpty()) {
            EncomendaDTO encomenda = clienteService.rastrearEncomenda(codigo);
            model.addAttribute("encomenda", encomenda);
            return "minhaencomenda";
        } else {
            model.addAttribute("erroRastreio", "Código de rastreio incorreto");
            return "index";
        }
        
    }

}