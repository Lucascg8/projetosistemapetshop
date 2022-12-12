package br.univille.projetosistemapetshop.service;
import java.util.List;

import br.univille.projetosistemapetshop.entity.Pet;

public interface PetService {
    List<Pet> getAll();
    Pet save(Pet pet);
    Pet findById(long id);
    void delete(long id);
    List<Pet> findByNome(String nome);
}