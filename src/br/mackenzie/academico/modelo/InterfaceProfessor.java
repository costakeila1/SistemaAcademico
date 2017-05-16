package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.Professor;
import java.util.List;

public interface InterfaceProfessor {

    public Oferecimento recuperaOferecimento(String codComponente, String codTurma);

    public void criaProfessor(Professor novoProfessor);

    public List<Professor> listaProfessores();

    public Professor recuperaProfessor(String drt);

    public void atualizaProfessor(Professor p);

    public void removeProfessor(Professor p);
    
}
