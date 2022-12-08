package br.univille.projetosistemapetshop.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosistemapetshop.entity.Pet;
import br.univille.projetosistemapetshop.service.ClienteService;
import br.univille.projetosistemapetshop.service.PetService;

@Controller
@RequestMapping("/pet")
public class PetController {
    
    @Autowired
    private PetService service;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index(){
        var listaPets = service.getAll();
        return new ModelAndView("pet/index","listaPets",listaPets);
    }

    @GetMapping("/consulta")
    public ModelAndView indexConsulta(){
        var listaPets = service.getAll();
        return new ModelAndView("pet/index2","listaPets",listaPets);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var pet = new Pet();
        var listaClientes = clienteService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet",pet);
        dados.put("listaClientes",listaClientes);
        return new ModelAndView("pet/form", dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umPet = service.findById(id);
        var listaClientes = clienteService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet",umPet);
        dados.put("listaClientes",listaClientes);
        return new ModelAndView("pet/form",dados);
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Pet pet,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            var listaClientes = clienteService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("pet",pet);
            dados.put("listaClientes",listaClientes);
            return new ModelAndView("pet/form",dados);
        }
        service.save(pet);
        return new ModelAndView("redirect:/pet");
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);
        return new ModelAndView("redirect:/pet");
    }
}
