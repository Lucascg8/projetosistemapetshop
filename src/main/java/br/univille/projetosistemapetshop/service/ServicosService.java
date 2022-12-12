package br.univille.projetosistemapetshop.service;
import java.util.List;

import br.univille.projetosistemapetshop.entity.Servicos;

public interface ServicosService {
    List<Servicos> getAll();
    Servicos save(Servicos servico);
    Servicos findById(long id);
    void delete(long id);
    List<Servicos> findByNome(String nome);
}