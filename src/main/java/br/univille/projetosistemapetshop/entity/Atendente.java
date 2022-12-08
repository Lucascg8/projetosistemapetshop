package br.univille.projetosistemapetshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Atendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 500, nullable = false)
    @NotBlank(message = "O campo nome não pode ser em branco")
    private String nome;
    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo usuario não pode ser em branco")
    private String usuario;
    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo senha não pode ser em branco")
    private String senha;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}