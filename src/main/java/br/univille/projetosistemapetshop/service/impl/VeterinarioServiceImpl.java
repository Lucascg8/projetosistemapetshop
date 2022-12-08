package br.univille.projetosistemapetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosistemapetshop.entity.Veterinario;
import br.univille.projetosistemapetshop.repository.VeterinarioRepository;
import br.univille.projetosistemapetshop.service.VeterinarioService;

@Service
public class VeterinarioServiceImpl implements VeterinarioService{
    
    @Autowired
    private VeterinarioRepository repositorio;

    @Override
    public List<Veterinario> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Veterinario save(Veterinario veterinario) {
        return repositorio.save(veterinario);
    }

    @Override
    public Veterinario findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Veterinario();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Veterinario> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
}