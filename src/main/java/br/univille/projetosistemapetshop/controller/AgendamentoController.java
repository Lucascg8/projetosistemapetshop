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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosistemapetshop.entity.Agendamento;
import br.univille.projetosistemapetshop.entity.Servicos;
import br.univille.projetosistemapetshop.service.AgendamentoService;
import br.univille.projetosistemapetshop.service.AtendenteService;
import br.univille.projetosistemapetshop.service.PetService;
import br.univille.projetosistemapetshop.service.VeterinarioService;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService service;
    @Autowired
    private AtendenteService atendenteService;
    @Autowired
    private VeterinarioService veterinarioService;
    @Autowired
    private PetService petService;
    
    @GetMapping
    public ModelAndView index(){
        var listaAgendamentos = service.getAll();
        return new ModelAndView("agendamento/index","listaAgendamentos",listaAgendamentos);
    }

    @GetMapping("/consulta")
    public ModelAndView indexConsulta(){
        var listaAgendamentos = service.getAll();
        return new ModelAndView("agendamento/index2","listaAgendamentos",listaAgendamentos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoAgendamento = new Agendamento();
        var listaPets = petService.getAll();
        var listaAtendentes = atendenteService.getAll();
        var listaVeterinarios = veterinarioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("agendamento", novoAgendamento);
        dados.put("listaPets", listaPets);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaVeterinarios", listaVeterinarios);
        dados.put("novoServico", new Servicos());
        return new ModelAndView("agendamento/form",dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Valid Agendamento agendamento,BindingResult bindingResult){
        service.save(agendamento);
        return new ModelAndView("redirect:/agendamento");
    }

    @PostMapping(params = "incluiAgenda")
    public ModelAndView incluirAgenda(Agendamento agendamento, Servicos novoServico){
        agendamento.getListaColServicos().add(novoServico);
        var listaAgenda = atendenteService.getAll();
        var listaAgendamentos = veterinarioService.getAll();
        var agenda = petService.getAll();
        var listaPets = petService.getAll();
        var listaVeterinarios = veterinarioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("agendamento", agendamento);
        dados.put("listaPets", listaPets);
        dados.put("listaAgenda", listaAgenda);
        dados.put("listaVeterinarios", listaVeterinarios);
        dados.put("listaAgendamentos", listaAgendamentos);
        dados.put("agenda", agenda);
        dados.put("novoServico", new Servicos());
        return new ModelAndView("agendamento/form",dados);
    }

    @PostMapping(params = "removeAgenda")
    public ModelAndView removerItem(@RequestParam("removeAgenda")int index, Agendamento agendamento){
        agendamento.getListaColServicos().remove(index);   
        var listaAgenda = atendenteService.getAll();
        var listaAgendamentos = veterinarioService.getAll();
        var agenda = petService.getAll();
        var listaPets = petService.getAll();
        var listaVeterinarios = veterinarioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("agendamento", agendamento);
        dados.put("listaPets", listaPets);
        dados.put("listaAgenda", listaAgenda);
        dados.put("listaVeterinarios", listaVeterinarios);
        dados.put("listaAgendamentos", listaAgendamentos);
        dados.put("agenda", agenda);
        dados.put("novoServico", new Servicos());
        return new ModelAndView("agendamento/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umAgendamento = service.findById(id);
        var listaPets = petService.getAll();
        var listaAgenda = atendenteService.getAll();
        var agenda = petService.getAll();
        var listaAtendentes = atendenteService.getAll();
        var listaVeterinarios = veterinarioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("agendamento", umAgendamento);
        dados.put("listaPets", listaPets);
        dados.put("listaAgenda", listaAgenda);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaVeterinarios", listaVeterinarios);
        dados.put("agenda", agenda);
        dados.put("novoServico", new Servicos());
        return new ModelAndView("agendamento/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/agendamento");
    }
}
