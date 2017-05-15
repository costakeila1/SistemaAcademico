/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.dominio;

import java.io.Serializable;

/**
 *
 * @author gabriel domenicali
 */
public class ProjetoPedagogico implements Serializable{
    private String justificativa;
    private String perfil;
    private Curso curso;
    
    public ProjetoPedagogico(String justificativa, String perfil, Curso curso){
        this.justificativa = justificativa;
        this.perfil = perfil;
        this.curso = curso;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }   

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }    
}