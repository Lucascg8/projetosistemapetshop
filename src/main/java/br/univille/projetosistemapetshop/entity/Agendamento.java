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
import javax.persistence.ManyToMany;
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

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Atendente listaAgendamentos;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Veterinario listaAgenda;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agendamento_id")
    private List<Servicos> listaServicos = new ArrayList<>();

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

    public Atendente getListaAgendamentos() {
        return listaAgendamentos;
    }

    public void setListaAgendamentos(Atendente listaAgendamentos) {
        this.listaAgendamentos = listaAgendamentos;
    }

    public Veterinario getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(Veterinario listaAgenda) {
        this.listaAgenda = listaAgenda;
    }

    public List<Servicos> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servicos> listaServicos) {
        this.listaServicos = listaServicos;
    }

    
}