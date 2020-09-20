package me.pimpao.ordemservico.dto;

import java.time.LocalDateTime;

public class OrdemServicoDto {

    private String ordemId;
    private String clienteId;
    private String equipamentoId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataInicial;
    private LocalDateTime dataConclusao;
    private String responsavel;

    public String getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(String ordemId) {
        this.ordemId = ordemId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(String equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
