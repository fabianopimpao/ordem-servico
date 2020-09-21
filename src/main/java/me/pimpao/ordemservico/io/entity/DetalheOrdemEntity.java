package me.pimpao.ordemservico.io.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalhe_ordem")
public class DetalheOrdemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detalheOrdemId;
    private LocalDateTime dataCriacao;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "ordem_id")
    private OrdemServicoEntity ordemServicoEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalheOrdemId() {
        return detalheOrdemId;
    }

    public void setDetalheOrdemId(String detalheOrdemId) {
        this.detalheOrdemId = detalheOrdemId;
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

    public OrdemServicoEntity getOrdemServicoEntity() {
        return ordemServicoEntity;
    }

    public void setOrdemServicoEntity(OrdemServicoEntity ordemServicoEntity) {
        this.ordemServicoEntity = ordemServicoEntity;
    }
}
