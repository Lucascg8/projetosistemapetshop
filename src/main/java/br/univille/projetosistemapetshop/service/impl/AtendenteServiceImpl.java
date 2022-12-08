package br.univille.projetosistemapetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosistemapetshop.entity.Atendente;
import br.univille.projetosistemapetshop.repository.AtendenteRepository;
import br.univille.projetosistemapetshop.service.AtendenteService;

@Service
public class AtendenteServiceImpl implements AtendenteService{
    
    @Autowired
    private AtendenteRepository repositorio;

    @Override
    public List<Atendente> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Atendente save(Atendente atendente) {
        return repositorio.save(atendente);
    }

    @Override
    public Atendente findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Atendente();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Atendente> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
}