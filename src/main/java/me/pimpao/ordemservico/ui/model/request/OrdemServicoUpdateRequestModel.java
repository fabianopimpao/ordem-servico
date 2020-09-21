package me.pimpao.ordemservico.ui.model.request;

import javax.validation.constraints.NotEmpty;

public class OrdemServicoUpdateRequestModel {

    private String responsavel;

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
