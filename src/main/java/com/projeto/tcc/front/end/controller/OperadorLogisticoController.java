/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.model.ClienteDTO;
import com.projeto.tcc.front.end.service.EncomendaService;
import com.projeto.tcc.front.end.service.OperadorLogisticoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperadorLogisticoController {

    @Autowired
    private OperadorLogisticoService operadorLogisticoService;
    
    @Autowired
    private EncomendaService encomendaService;

    @PostMapping("/operador/cadastrar/encomendas")
    public String cadastrarEncomenda(@ModelAttribute ClienteDTO cliente, HttpSession session, Model model) {
        
        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }

        String token = (String) session.getAttribute("token");
        operadorLogisticoService.cadastrarEncomenda(token, cliente);
        
        return "redirect:/operador/encomendas";
    }

    @GetMapping("/operador/entregadores/disponiveis")
    public String listarEntregadoresDisponiveis(HttpSession session, Model model) {
        
        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }
        String token = (String) session.getAttribute("token");
        model.addAttribute("entregadores", operadorLogisticoService.listarEntregadoresDisponiveis(token));
        model.addAttribute("encomendas", encomendaService.listarEncomendasDoOperador(token));
        
        return "operadorentregador";
    }

    @PostMapping("/operador/escolher/entregador")
    public String escolherEntregador(@RequestParam Integer idEncomenda, @RequestParam Integer idEntregador, HttpSession session) {
        
        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }
        
        String token = (String) session.getAttribute("token");
        operadorLogisticoService.escolherEntregador(idEncomenda, token, idEntregador);
        
        return "redirect:/operador/entregadores/disponiveis";
    }

}