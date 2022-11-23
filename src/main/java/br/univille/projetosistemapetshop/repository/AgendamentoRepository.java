package br.univille.projetosistemapetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetosistemapetshop.entity.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long>{
    
}
