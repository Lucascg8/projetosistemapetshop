package br.univille.projetosistemapetshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date time;
    
    @Column(length = 3000)
    private float valorTotal;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Pet agenda;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Atendente atendente;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Veterinario veterinario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agendamento_id")
    private List<Servicos> listaColServicos = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pet getAgenda() {
        return agenda;
    }

    public void setAgenda(Pet agenda) {
        this.agenda = agenda;
    }

    public List<Servicos> getListaColServicos() {
        return listaColServicos;
    }

    public void setListaColServicos(List<Servicos> listaColServicos) {
        this.listaColServicos = listaColServicos;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    
}