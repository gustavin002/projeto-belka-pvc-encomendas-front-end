/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.service.EncomendaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncomendaController {

    @Autowired
    private EncomendaService encomendaService;

    public String listarEncomendasPorOperador(HttpSession session, Model model, Integer idOperadorLogistico) { 
    
    if (session.getAttribute("token") == null) {
        return "redirect:/login";
    }

    String token = (String) session.getAttribute("token");

    if (idOperadorLogistico != null) {
        model.addAttribute("encomendas", encomendaService.listarEncomendasPorOperador(token, idOperadorLogistico));
    }
    
    return "operadorencomendas";
        
    }

    @GetMapping("/operador/encomendas/cliente")
    public String listarEncomendasPorCliente(@RequestParam(required = false) Integer idCliente, HttpSession session, Model model) {
        
        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }

        if (idCliente != null) {
            String token = (String) session.getAttribute("token");
            model.addAttribute("encomendas", encomendaService.listarEncomendasPorCliente(token, idCliente));
        }
        
        return "operadorcliente";
    }

}