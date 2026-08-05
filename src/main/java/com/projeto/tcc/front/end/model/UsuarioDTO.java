/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.model;

public class UsuarioDTO {

    private Integer idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String roleUsuario;
    private String disponibilidadeUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getRoleUsuario() {
        return roleUsuario;
    }

    public void setRoleUsuario(String roleUsuario) {
        this.roleUsuario = roleUsuario;
    }
    
    public String getDisponibilidadeUsuario() {
        return disponibilidadeUsuario;
    }

    public void setDisponibilidadeUsuario(String disponibilidadeUsuario) {
        this.disponibilidadeUsuario = disponibilidadeUsuario;
    }

}