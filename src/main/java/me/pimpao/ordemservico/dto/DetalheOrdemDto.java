package me.pimpao.ordemservico.dto;

import java.time.LocalDateTime;

public class DetalheOrdemDto {

    private Long id;
    private String ordemId;
    private LocalDateTime dataCriacao;
    private String motivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(String ordemId) {
        this.ordemId = ordemId;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
