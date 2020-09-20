package me.pimpao.ordemservico.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ClienteRequestModel {

    @NotEmpty(message = "Preenchimento obrigatório")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    private List<EnderecoRequestModel> enderecos;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String telefone;

    @Email(message = "Email inválido")
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EnderecoRequestModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoRequestModel> enderecos) {
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
