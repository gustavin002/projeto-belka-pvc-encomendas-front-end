/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.model;


public class EncomendaDTO {
    
    private Integer idEncomenda;
    private String codigoRastreioEncomenda;
    private String enderecoAtualEncomenda;
    private String statusEncomenda;
    private String atribuicaoEncomenda;
    private ClienteDTO cliente;
    private OperadorLogisticoDTO operadorLogistico;

    public Integer getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Integer idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public String getCodigoRastreioEncomenda() {
        return codigoRastreioEncomenda;
    }

    public void setCodigoRastreioEncomenda(String codigoRastreioEncomenda) {
        this.codigoRastreioEncomenda = codigoRastreioEncomenda;
    }

    public String getEnderecoAtualEncomenda() {
        return enderecoAtualEncomenda;
    }

    public void setEnderecoAtualEncomenda(String enderecoAtualEncomenda) {
        this.enderecoAtualEncomenda = enderecoAtualEncomenda;
    }

    public String getStatusEncomenda() {
        return statusEncomenda;
    }

    public void setStatusEncomenda(String statusEncomenda) {
        this.statusEncomenda = statusEncomenda;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public OperadorLogisticoDTO getOperadorLogistico() {
        return operadorLogistico;
    }

    public void setOperadorLogistico(OperadorLogisticoDTO operadorLogistico) {
        this.operadorLogistico = operadorLogistico;
    }

    public String getAtribuicaoEncomenda() {
        return atribuicaoEncomenda;
    }

    public void setAtribuicaoEncomenda(String atribuicaoEncomenda) {
        this.atribuicaoEncomenda = atribuicaoEncomenda;
    }

}
