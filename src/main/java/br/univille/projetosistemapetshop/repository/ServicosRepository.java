package br.univille.projetosistemapetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetosistemapetshop.entity.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos,Long>{
    
}
