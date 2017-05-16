package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.Professor;
import br.mackenzie.academico.modelo.InterfaceProfessor;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerProfessor {
    
    private InterfaceProfessor iProfessor;
    
    public ControllerProfessor(){
        iProfessor = (InterfaceProfessor) Modelo.getInstance();
    }

    public void criaProfessor(String nome, String drt, String codComponente, String codTurma) {
        Oferecimento oferecimento = iProfessor.recuperaOferecimento(codComponente, codTurma);
        Professor novoProfessor = new Professor (oferecimento);
        novoProfessor.setNome(nome);
        novoProfessor.setDRT(drt);
        iProfessor.criaProfessor(novoProfessor);
    }

    public List<Professor> listaProfessores() {
        return iProfessor.listaProfessores();
    }

    public Professor recuperaProfessor(String drt) {
        return iProfessor.recuperaProfessor(drt);
    }

    public void atualizaProfessor(Professor p, String codComponente, String codTurma) {
        Oferecimento oferecimento = iProfessor.recuperaOferecimento(codComponente, codTurma);
        p.setOferecimento(oferecimento);
        iProfessor.atualizaProfessor(p);
    }

    public void removeProfessor(Professor p) {
        iProfessor.removeProfessor(p);
    }
    
}
