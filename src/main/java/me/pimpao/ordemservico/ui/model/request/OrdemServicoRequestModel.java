package me.pimpao.ordemservico.ui.model.request;

import javax.validation.constraints.NotEmpty;

public class OrdemServicoRequestModel {

    @NotEmpty(message = "Preenchimento obrigatório")
    private String clienteId;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String equipamentoId;

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
}
