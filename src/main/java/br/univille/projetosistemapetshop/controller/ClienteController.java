package br.univille.projetosistemapetshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosistemapetshop.entity.Cliente;
import br.univille.projetosistemapetshop.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente(); 
        return new ModelAndView("cliente/form","cliente",cliente);
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umCliente = service.findById(id);
        return new ModelAndView("cliente/form","cliente",umCliente);
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cliente cliente,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ModelAndView("cliente/form","cliente",cliente);
        }
        service.save(cliente);
        return new ModelAndView("redirect:/cliente");
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);
        return new ModelAndView("redirect:/cliente");
    }
}
