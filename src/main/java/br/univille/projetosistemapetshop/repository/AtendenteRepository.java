package br.univille.projetosistemapetshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetosistemapetshop.entity.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente,Long>{
    List<Atendente> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
