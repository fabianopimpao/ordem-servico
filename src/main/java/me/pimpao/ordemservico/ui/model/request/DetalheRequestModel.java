package me.pimpao.ordemservico.ui.model.request;

import java.time.LocalDateTime;

public class DetalheRequestModel {

    private String ordemId;
    private String motivo;

    public String getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(String ordemId) {
        this.ordemId = ordemId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
