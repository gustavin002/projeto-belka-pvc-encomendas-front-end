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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/minha-encomenda")
    public String minhaEncomenda() {
        return "minha-encomenda";
    }
    
    @GetMapping("/rastreio")
    public String rastrear(@RequestParam(required = false) String codigo, Model model) {

        if (codigo != null && !codigo.isEmpty()) {
            EncomendaDTO encomenda = clienteService.rastrearEncomenda(codigo);
            model.addAttribute("encomenda", encomenda);
        }

        return "rastreio";
    }

    @PostMapping("/rastrear")
    public String rastrear(@RequestParam String codigoRastreio, RedirectAttributes redirectAttributes) {

        try {
            EncomendaDTO encomenda = clienteService.rastrearEncomenda(codigoRastreio);
            redirectAttributes.addFlashAttribute("encomenda", encomenda);
            return "redirect:/minha-encomenda";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erroRastreio", "Código de rastreio incorreto");
            return "redirect:/";
        }
    }

    
    
}