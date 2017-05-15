/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.GradeCurricular;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.modelo.InterfaceGradeCurricular;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

/**
 *
 * @author gabriel domenicali
 */
public class ControllerGradeCurricular {
    
    private InterfaceGradeCurricular igrade;
    
    public ControllerGradeCurricular(){
        igrade = (InterfaceGradeCurricular) Modelo.getInstance();
    }

    public void criaGradeCurricular(String strProjetoPedagogico, String strInformacoes) {
         ProjetoPedagogico p = Modelo.getInstance().recuperaProjetoPedagogico();
         GradeCurricular novaGradeCurricular= new GradeCurricular(p);
         novaGradeCurricular.setInformacoes(strInformacoes);
         igrade.criaGradeCurricular(novaGradeCurricular);
    }

    public List<GradeCurricular> listaGradesCurriculares() {
        return igrade.listaGradesCurriculares();
    }

    public GradeCurricular recuperaGradeCurricular(String projetoPedagogico) {
        return igrade.recuperaGradeCurricular(projetoPedagogico);
    }

    public void atualizaGradeCurricular(GradeCurricular gradeCurricular) {
        igrade.atualizaGradeCurricular(gradeCurricular);
    }

    public void removeGradeCurricular(GradeCurricular gradeCurricular) {
        igrade.removeGradeCurricular(gradeCurricular);
    }
}