package br.univille.projetosistemapetshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 500, nullable = false)
    //@NotBlank(message = "O campo nome não pode ser em branco")
    private String nome;
    @Column(length = 500, nullable = false)
    //@NotBlank(message = "O campo animal não pode ser em branco")
    private String animal;
    @Column(length = 500)
    private float tamanho;
    @Column(length = 500)
    private float peso;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    private Cliente dono;


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
    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    public float getTamanho() {
        return tamanho;
    }
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public Cliente getDono() {
        return dono;
    }
    public void setDono(Cliente dono) {
        this.dono = dono;
    }

}