//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

import java.io.Serializable;

public class Oferecimento implements Serializable {

    private ComponenteCurricular componenteCurricular;
    private Turma turma;
    private String informacoesAdicionais;

    public Oferecimento(Turma turma, ComponenteCurricular componenteCurricular) {
        this.turma = turma;
        this.componenteCurricular = componenteCurricular;
    }

    public ComponenteCurricular getComponenteCurricular() {
        return componenteCurricular;
    }

    public Turma getTurma() {
        return turma;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

}
