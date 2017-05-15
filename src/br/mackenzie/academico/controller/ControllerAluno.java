//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.excecao.AlunoNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceAluno;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerAluno {
    
    private InterfaceAluno iAluno;
    
    public ControllerAluno(){
        iAluno = (InterfaceAluno) Modelo.getInstance();
    }

    public void criaAluno(String nome, String tia, String codigo_turma){
        Aluno novoAluno = new Aluno(iAluno.recuperaTurma(codigo_turma));
        novoAluno.setNome(nome);
        novoAluno.setTIA(tia);
        iAluno.criaAluno(novoAluno);
    }

    public List<Aluno> listaAlunos() {
        return iAluno.listaAlunos();
    }

    public Aluno recuperaAluno(String tia) throws AlunoNaoEncontradoException{
        return iAluno.recuperaAluno(tia);
    }

    public void atualizaAluno(Aluno aluno) {
        iAluno.atualizaAluno(aluno);
    }

    public void removeAluno(Aluno aluno) {
        iAluno.removeAluno(aluno);
    }

    public Turma recuperaTurma(String strturma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
