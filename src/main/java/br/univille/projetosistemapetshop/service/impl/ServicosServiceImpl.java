package br.univille.projetosistemapetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosistemapetshop.entity.Servicos;
import br.univille.projetosistemapetshop.repository.ServicosRepository;
import br.univille.projetosistemapetshop.service.ServicosService;

@Service
public class ServicosServiceImpl  implements ServicosService{
    
    @Autowired
    private ServicosRepository repositorio;

    @Override
    public List<Servicos> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Servicos save(Servicos servicos){
        return repositorio.save(servicos);
    }

    @Override
    public Servicos findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
       return new Servicos();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}