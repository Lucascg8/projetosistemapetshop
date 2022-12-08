package br.univille.projetosistemapetshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    private int contador;

    //@GetMapping({"/","/atendente"})
    @GetMapping
    public ModelAndView index(){
        contador++;
        return new ModelAndView("home/index","valor",contador);
    }
    @GetMapping("/souatendente")
    public ModelAndView index2(){
        contador++;
        return new ModelAndView("home/index2","valor",contador);
    }
    @GetMapping("/souveterinario")
    public ModelAndView index3(){
        contador++;
        return new ModelAndView("home/index3","valor",contador);
    }
}