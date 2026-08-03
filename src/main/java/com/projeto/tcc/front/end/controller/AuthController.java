/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.model.AdminDTO;
import com.projeto.tcc.front.end.model.UserRequestDTO;
import com.projeto.tcc.front.end.model.UsuarioDTO;
import com.projeto.tcc.front.end.service.AdminService;
import com.projeto.tcc.front.end.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("credenciais", new UserRequestDTO());
        return "login";
    }

    @PostMapping("/logar")
    public String logar(@ModelAttribute UserRequestDTO credenciais, HttpSession session,
        RedirectAttributes redirectAttributes) {

        try {
            String tokenAdmin = adminService.login(credenciais);
            AdminDTO admin = adminService.buscarAdminLogado(tokenAdmin);

            session.setAttribute("idAdmin", admin.getIdAdmin());
            session.setAttribute("tipoUsuario", "admin");
            session.setAttribute("token", tokenAdmin);
            
            return "redirect:/admin";

        } catch (Exception e) {

        }

        try {
            String token = usuarioService.login(credenciais);
            UsuarioDTO usuarioLogado = usuarioService.buscarUsuarioLogado(token);

            session.setAttribute("token", token);
            session.setAttribute("idUsuario", usuarioLogado.getIdUsuario());
            session.setAttribute("nomeUsuario", usuarioLogado.getNomeUsuario());

            String role = usuarioLogado.getRoleUsuario();
            session.setAttribute("tipoUsuario", role);

            if (role.equalsIgnoreCase("entregador")) {
                return "redirect:/listar/entregas/entregador";
            } 
                return "redirect:/operador/encomendas";
            
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erroLogin", "Email ou senha inválidos");
            return "redirect:/login";
        }
    }
    

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}