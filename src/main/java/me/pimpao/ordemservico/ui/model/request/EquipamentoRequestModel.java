package me.pimpao.ordemservico.ui.model.request;

import javax.validation.constraints.NotEmpty;

public class EquipamentoRequestModel {

    @NotEmpty(message = "Preenchimento obrigatório")
    private String descricao;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String tipo;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String marca;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String situacao;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String clienteId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

}
