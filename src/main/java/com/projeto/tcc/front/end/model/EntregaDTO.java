/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.front.end.model;

import java.time.LocalDateTime;

public class EntregaDTO {
    
    private Integer idEntrega;
    private LocalDateTime dataHoraEntrega;
    private String codigoOtpEntrega;
    private EncomendaDTO encomenda;
    private EntregadorDTO entregador;
    
    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getCodigoOtpEntrega() {
        return codigoOtpEntrega;
    }

    public void setCodigoOtpEntrega(String codigoOtpEntrega) {
        this.codigoOtpEntrega = codigoOtpEntrega;
    }

    public EncomendaDTO getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(EncomendaDTO encomenda) {
        this.encomenda = encomenda;
    }

    public EntregadorDTO getEntregador() {
        return entregador;
    }

    public void setEntregador(EntregadorDTO entregador) {
        this.entregador = entregador;
    }
    
}
