package br.univille.projetosistemapetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosistemapetshop.entity.Servicos;
import br.univille.projetosistemapetshop.service.ServicosService;

@Controller
@RequestMapping("/servicos")
public class ServicosController {
    
    @Autowired
    private ServicosService service;

    @GetMapping
    public ModelAndView index(){
        var listaServicos = service.getAll();
        return new ModelAndView("servicos/index","listaServicos",listaServicos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var servicoNovo = new Servicos();
        return new ModelAndView("servicos/form","servico",servicoNovo);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Servicos servicos){
        service.save(servicos);
        return new ModelAndView("redirect:/servicos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umServico = service.findById(id);
        return new ModelAndView("servicos/form","servico",umServico);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/servicos");
    }
}