package br.com.academy.controllers;

import br.com.academy.dao.AlunoDao;
import br.com.academy.model.Aluno;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {

    @Autowired
    private AlunoDao alunorepositorio;

    @GetMapping("/inserirAlunos")
    public ModelAndView InserirAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("/inserirAlunos")
    public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {
        ModelAndView mv = new ModelAndView();

        if (br.hasErrors()) {
            mv.setViewName("Aluno/formAluno");
            mv.addObject("aluno", aluno);
            return mv;
        }

        alunorepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adicionados");
        return mv;
    }

    @GetMapping("alunos-adicionados")
    public ModelAndView listagemAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listAlunos");
        mv.addObject("alunosList", alunorepositorio.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/alterar");
        Aluno aluno = alunorepositorio.getOne(id);
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        alunorepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id) {
        alunorepositorio.deleteById(id);
        return "redirect:/alunos-adicionados";
    }

}
