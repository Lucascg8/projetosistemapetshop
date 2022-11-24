package br.univille.projetosistemapetshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetosistemapetshop.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long>{
    List<Pet> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
