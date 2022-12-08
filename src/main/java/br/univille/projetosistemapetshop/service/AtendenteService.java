package br.univille.projetosistemapetshop.service;
import java.util.List;
import br.univille.projetosistemapetshop.entity.Atendente;

public interface AtendenteService {
    List<Atendente> getAll();
    Atendente save(Atendente atendente);
    Atendente findById(long id);
    void delete(long id);
    List<Atendente> findByNome(String nome);
}