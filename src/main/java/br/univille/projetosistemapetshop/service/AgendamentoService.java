package br.univille.projetosistemapetshop.service;
import java.util.List;
import br.univille.projetosistemapetshop.entity.Agendamento;

public interface AgendamentoService {
    List<Agendamento> getAll();
    void save(Agendamento agendamento);
    Agendamento findById(long id);
}
