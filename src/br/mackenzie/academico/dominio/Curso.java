//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

import java.io.Serializable;

public class Curso implements Serializable{

    private String nome;
    private Faculdade faculdade;

    public Curso(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
