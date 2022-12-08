package br.univille.projetosistemapetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosistemapetshop.entity.Pet;
import br.univille.projetosistemapetshop.repository.PetRepository;
import br.univille.projetosistemapetshop.service.PetService;

@Service
public class PetServiceImpl implements PetService{
    
    @Autowired
    private PetRepository repositorio;

    @Override
    public List<Pet> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return repositorio.save(pet);
    }

    @Override
    public Pet findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Pet();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Pet> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
}