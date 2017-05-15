//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.Turma;
import java.util.List;

public interface InterfaceAluno {

    public Turma recuperaTurma(String codigo_turma);

    public void criaAluno(Aluno novoAluno);

    public List<Aluno> listaAlunos();

    public Aluno recuperaAluno(String tia);

    public void atualizaAluno(Aluno aluno);

    public void removeAluno(Aluno aluno);
    
}
