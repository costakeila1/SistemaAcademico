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
public class Professor implements Serializable{
    private String DRT;
    private String nome;
    private Oferecimento oferecimento;
    
    public Professor(Oferecimento oferecimento){
        this.oferecimento = oferecimento;
    }

    public String getDRT() {
        return DRT;
    }

    public void setDRT(String DRT) {
        this.DRT = DRT;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Oferecimento getOferecimento() {
        return oferecimento;
    }

    public void setOferecimento(Oferecimento oferecimento) {
        this.oferecimento = oferecimento;
    }   
}