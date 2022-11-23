package br.univille.projetosistemapetshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 500, nullable = false)
    @NotBlank(message = "O campo nome não pode ser em branco")
    private String nome;
    @Column(length = 30, nullable = false)
    @NotBlank(message = "O campo usuario não pode ser em branco")
    private String usuario;
    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo senha não pode ser em branco")
    private String senha;
}
