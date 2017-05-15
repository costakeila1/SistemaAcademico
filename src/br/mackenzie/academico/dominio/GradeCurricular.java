package br.mackenzie.academico.dominio;

import java.io.Serializable;

public class GradeCurricular implements Serializable {

    private ProjetoPedagogico projetoPedagogico;
    private String informacoes;

    public GradeCurricular(ProjetoPedagogico projetoPedagogico) {
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
