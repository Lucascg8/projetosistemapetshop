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

import br.univille.projetosistemapetshop.entity.Veterinario;
import br.univille.projetosistemapetshop.service.VeterinarioService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
    
    @Autowired
    private VeterinarioService service;

    @GetMapping
    public ModelAndView index(){
        var listaVeterinarios = service.getAll();
        return new ModelAndView("veterinario/index","listaVeterinarios",listaVeterinarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var veterinario = new Veterinario();
        return new ModelAndView("veterinario/form","veterinario",veterinario);
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umVeterinario = service.findById(id);
        return new ModelAndView("veterinario/form","veterinario",umVeterinario);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Veterinario veterinario,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ModelAndView("veterinario/form","veterinario",veterinario);
        }
        service.save(veterinario);
        return new ModelAndView("redirect:/veterinario");
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);
        return new ModelAndView("redirect:/veterinario");
    }
}
