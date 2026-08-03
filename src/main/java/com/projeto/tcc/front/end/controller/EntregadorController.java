/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.controller;

import com.projeto.tcc.front.end.service.EntregadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping("/entregador/entregas/{idEntrega}")
    public String verEntrega(@PathVariable Integer idEntrega, HttpSession session, Model model) {
        
        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }
        
        String token = (String) session.getAttribute("token");
        model.addAttribute("entrega", entregadorService.verEntrega(idEntrega, token));
        return "entregadorentregas";
    }

    @PostMapping("/entregador/entregas/{idEntrega}/status")
    public String atualizarStatus(@PathVariable Integer idEntrega, @RequestParam String novoStatus, HttpSession session) {

        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }
        
        String token = (String) session.getAttribute("token");
        entregadorService.atualizarStatus(idEntrega, token, novoStatus);
        return "redirect:/entregador/entregas/" + idEntrega;
    }

    @PostMapping("/entregador/entregas/{idEntrega}/local")
    public String atualizarLocal(@PathVariable Integer idEntrega, @RequestParam String novoLocal, HttpSession session) {

        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }
        
        String token = (String) session.getAttribute("token");
        entregadorService.atualizarLocalAtual(idEntrega, token, novoLocal);
        return "redirect:/entregador/entregas/" + idEntrega;
    }

    @PostMapping("/entregador/entregas/{idEntrega}/validar-otp")
    public String validarOtp(@PathVariable Integer idEntrega, @RequestParam String otpDigitado,
        HttpSession session, RedirectAttributes redirectAttributes) {

        if (session.getAttribute("token") == null) {
            return "redirect:/login";
        }

        try {
            String token = (String) session.getAttribute("token");
            entregadorService.validarOTP(idEntrega, token, otpDigitado);
            redirectAttributes.addFlashAttribute("sucessoEntrega", "Entrega feita com sucesso!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erroOtp", "Código OTP inválido");
        }

        return "redirect:/entregador/entregas/" + idEntrega;
    }

}