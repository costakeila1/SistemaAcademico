//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

import java.io.Serializable;

public class Aluno implements java.io.Serializable {

    private String nome;
    private String TIA;
    private Turma turma;

    public Aluno(Turma turma) {
        this.turma = turma;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTIA() {
        return TIA;
    }

    public void setTIA(String TIA) {
        this.TIA = TIA;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
