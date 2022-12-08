package br.univille.projetosistemapetshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetosistemapetshop.entity.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long>{
    List<Veterinario> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}