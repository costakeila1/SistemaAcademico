//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import java.util.List;

public interface InterfaceMatricula {

    public Oferecimento recuperaOferecimento(String codigo_turma, String codigo_componente);

    public List<Matricula> listaMatriculas();

    public Matricula recuperaMatricula(Aluno aluno, Oferecimento oferecimento);

    public void atualizaMatricula(Matricula matricula);

    public void removeMatricula(Matricula m);

    public Aluno recuperaAluno(String tia);

    public void criaMatricula(Matricula matricula);
    
}
