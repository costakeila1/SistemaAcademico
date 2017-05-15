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
public class GradeCurricular implements Serializable{
    private ProjetoPedagogico projetoPedagogico;
    private String informacoes;
    
    public GradeCurricular(ProjetoPedagogico projetoPedagogico){
        this.projetoPedagogico = projetoPedagogico;
    }

    public ProjetoPedagogico getProjetoPedagogico() {
        return projetoPedagogico;
    }

    public void setProjetoPedagogico(ProjetoPedagogico projetoPedagogico) {
        this.projetoPedagogico = projetoPedagogico;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}
