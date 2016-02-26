/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sistemaCantinaICIL.model;

import java.math.BigDecimal;

/**
 * 
 * @author Aricelio - 19-01-2016
 */
public class FactoryRelatorioBalanceteMensal {

    private BigDecimal totalDespesa;
    private BigDecimal totalRendimento;
    private BigDecimal lucro;
    
    // Getters e Setters

    public BigDecimal getTotalDespesa() {
        return totalDespesa;
    }

    public void setTotalDespesa(BigDecimal totalDespesa) {
        this.totalDespesa = totalDespesa;
    }

    public BigDecimal getTotalRendimento() {
        return totalRendimento;
    }

    public void setTotalRendimento(BigDecimal totalRendimento) {
        this.totalRendimento = totalRendimento;
    }

    public BigDecimal getLucro() {
        return lucro;
    }

    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }
    
}
