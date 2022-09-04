package br.com.fiap.accessiblemealapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereco;
    
    public Cliente() {
    }

    public Cliente(String nome, String cpf,String email, String senha, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", email=" + email + ", endereco="
                + endereco + ", id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
    }
    
}
