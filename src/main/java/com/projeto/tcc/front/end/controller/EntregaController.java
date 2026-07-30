/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.service.EntregaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping("/entregador")
    public String listarEntregasDoEntregador(HttpSession session, Model model) {
        
        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }

        String token = (String) session.getAttribute("token");
        model.addAttribute("entregas", entregaService.listarEntregasDoEntregador(token));
        return "entregador/minhas-entregas";
    }

}