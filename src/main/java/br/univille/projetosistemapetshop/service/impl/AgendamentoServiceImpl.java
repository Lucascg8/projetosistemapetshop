package br.univille.projetosistemapetshop.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosistemapetshop.entity.Agendamento;
import br.univille.projetosistemapetshop.repository.AgendamentoRepository;
import br.univille.projetosistemapetshop.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{
    
    @Autowired
    private AgendamentoRepository repository;
    @Override
    public List<Agendamento> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Agendamento agendamento){
        repository.save(agendamento);
    }

    @Override
    public Agendamento findById(long id) {
        var result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
       return new Agendamento();
    }
}
