package me.pimpao.ordemservico.io.entity;

import me.pimpao.ordemservico.io.enumeration.StatusOrdem;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordem_servico")
public class OrdemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ordemId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataInicial;
    private LocalDateTime dataConclusao;

    @Enumerated(value = EnumType.STRING)
    private StatusOrdem status;
    private String responsavel;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private EquipamentoEntity equipamentoEntity;

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

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public EquipamentoEntity getEquipamentoEntity() {
        return equipamentoEntity;
    }

    public void setEquipamentoEntity(EquipamentoEntity equipamentoEntity) {
        this.equipamentoEntity = equipamentoEntity;
    }
}
