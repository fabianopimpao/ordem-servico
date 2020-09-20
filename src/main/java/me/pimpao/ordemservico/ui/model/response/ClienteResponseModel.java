package me.pimpao.ordemservico.ui.model.response;

import java.util.List;

public class ClienteResponseModel {

    private String clienteId;
    private String nome;
    private List<EnderecoResponseModel> enderecos;
    private String telefone;
    private String email;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EnderecoResponseModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoResponseModel> enderecos) {
        this.enderecos = enderecos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
