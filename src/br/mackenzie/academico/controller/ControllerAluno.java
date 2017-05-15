//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.modelo.InterfaceAluno;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerAluno {
    
    private InterfaceAluno ialuno;
    
    public ControllerAluno(){
        ialuno = (InterfaceAluno) Modelo.getInstance();
    }

    public void criaAluno(String nome, String tia, String codigo_turma){
        Aluno novoAluno = new Aluno(ialuno.recuperaTurma(codigo_turma));
        novoAluno.setNome(nome);
        novoAluno.setTIA(tia);
        ialuno.criaAluno(novoAluno);
    }

    public List<Aluno> listaAlunos() {
        return ialuno.listaAlunos();
    }

    public Aluno recuperaAluno(String tia) {
        return ialuno.recuperaAluno(tia);
    }

    public void atualizaAluno(Aluno aluno) {
        ialuno.atualizaAluno(aluno);
    }

    public void removeAluno(Aluno aluno) {
        ialuno.removeAluno(aluno);
    }

    public Turma recuperaTurma(String strturma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
