package me.pimpao.ordemservico.dto;

import java.util.List;

public class ClienteDto {

    private String clienteId;
    private String nome;
    private List<EnderecoDto> enderecos;
    private String telefone;
    private String email;

    public String getClienteId() {
        return clienteId;
    }

    public void setId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDto> enderecos) {
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
