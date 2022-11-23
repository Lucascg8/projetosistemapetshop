package br.univille.projetosistemapetshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "O campo serviço não pode ser em branco")
    private String servico;
    @Column(length = 500, nullable = false)
    @NotBlank(message = "O campo valor não pode ser em branco")
    private float valor;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
