package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.Professor;
import br.mackenzie.academico.excecao.OferecimentoNaoEncontradoException;
import br.mackenzie.academico.excecao.ProfessorNaoEncontradoException;
import java.util.List;

public interface InterfaceProfessor {

    public Oferecimento recuperaOferecimento(String codComponente, String codTurma) throws OferecimentoNaoEncontradoException ;

    public void criaProfessor(Professor novoProfessor);

    public List<Professor> listaProfessores();

    public Professor recuperaProfessor(String drt) throws ProfessorNaoEncontradoException;

    public void atualizaProfessor(Professor p);

    public void removeProfessor(Professor p);
    
}
