/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.model.UsuarioDTO;
import com.projeto.tcc.front.end.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String painel(HttpSession session, Model model) {
        
        if (session.getAttribute("idAdmin") == null) {
            return "redirect:/login";
        }
        
        String token = (String) session.getAttribute("token");
        model.addAttribute("entregadores", adminService.listarEntregadores(token));
        model.addAttribute("operadores", adminService.listarOperadoresLogisticos(token));
        
        return "admin";
    }

    @GetMapping("/formcadastrar")
    public String formCadastrar(HttpSession session, Model model) {
        
        if (session.getAttribute("idAdmin") == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", new UsuarioDTO());
        
        return "admincadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute UsuarioDTO usuario, @RequestParam String role, HttpSession session,
            RedirectAttributes redirectAttributes) {

        if (session.getAttribute("idAdmin") == null) {
            return "redirect:/login";
        }

        String token = (String) session.getAttribute("token");
        
        if (role.equalsIgnoreCase("entregador")) {
            adminService.cadastrarEntregador(usuario, token);
        } else if (role.equalsIgnoreCase("operador logistico")){
            adminService.cadastrarOperadorLogistico(usuario, token);
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Erro!!! role inválida");
        }

        redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso!");
        
        return "redirect:/admin";
    }
    
}