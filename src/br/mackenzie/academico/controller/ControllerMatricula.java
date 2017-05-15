//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.excecao.AlunoNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceMatricula;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerMatricula {

    private InterfaceMatricula imatricula;

    public ControllerMatricula() {
        imatricula = (InterfaceMatricula) Modelo.getInstance();
    }

    public void criaMatricula(String tia, String codigo_turma, String codigo_componente) throws AlunoNaoEncontradoException {
        Aluno aluno = imatricula.recuperaAluno(tia);
        Oferecimento oferecimento = imatricula.recuperaOferecimento(codigo_turma, codigo_componente);
        Matricula matricula = new Matricula(aluno, oferecimento);
        imatricula.criaMatricula(matricula);
    }

    public List<Matricula> listaMatriculas() {
        return imatricula.listaMatriculas();
    }

    public Matricula recuperaMatricula(String tia, String codigo_turma, String codigo_componente) throws AlunoNaoEncontradoException {
        Aluno aluno = imatricula.recuperaAluno(tia);
        Oferecimento oferecimento = imatricula.recuperaOferecimento(codigo_turma, codigo_componente);
        Matricula matricula = imatricula.recuperaMatricula(aluno, oferecimento);
        return matricula;
    }

    public void atualizaMatricula(Matricula matricula) {
        imatricula.atualizaMatricula(matricula);
    }

    public void removeMatricula(Matricula m) {
        imatricula.removeMatricula(m);
    }

}
