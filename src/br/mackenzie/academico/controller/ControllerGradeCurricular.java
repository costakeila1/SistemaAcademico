//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.GradeCurricular;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.excecao.GradeCurricularNaoEncontradaException;
import br.mackenzie.academico.modelo.InterfaceGradeCurricular;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerGradeCurricular {
    
    private InterfaceGradeCurricular igrade;
    
    public ControllerGradeCurricular(){
        igrade = (InterfaceGradeCurricular) Modelo.getInstance();
    }

    public void criaGradeCurricular(String strProjetoPedagogico, String strInformacoes) {
         //ProjetoPedagogico p = Modelo.getInstance().recuperaProjetoPedagogico();
         //GradeCurricular novaGradeCurricular= new GradeCurricular(p);
        // novaGradeCurricular.setInformacoes(strInformacoes);
         //igrade.criaGradeCurricular(novaGradeCurricular);
    }

    public List<GradeCurricular> listaGradesCurriculares() {
        return igrade.listaGradesCurriculares();
    }

    public GradeCurricular recuperaGradeCurricular(String projetoPedagogico) throws GradeCurricularNaoEncontradaException {
        return igrade.recuperaGradeCurricular(projetoPedagogico);
    }

    public void atualizaGradeCurricular(GradeCurricular gradeCurricular) {
        igrade.atualizaGradeCurricular(gradeCurricular);
    }

    public void removeGradeCurricular(GradeCurricular gradeCurricular) {
        igrade.removeGradeCurricular(gradeCurricular);
    }
}