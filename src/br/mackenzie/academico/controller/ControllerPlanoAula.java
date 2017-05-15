/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.PlanoAula;
import br.mackenzie.academico.modelo.InterfacePlanoAula;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

/**
 *
 * @author gabriel domenicali
 */
public class ControllerPlanoAula {
    
    private InterfacePlanoAula iplanoaula;
    
    public ControllerPlanoAula(){
        iplanoaula = (InterfacePlanoAula) Modelo.getInstance();
    }

    public void criaPlanoAula(String calendarioLetivo, String oferecimento, String planejamentoAula, String bibliografiaBasica, String bibliografiaComplementar, String ementa, String conceitos, String conteudoProgramatico, String criteriosAvaliacao, String habilidades, String metodologia, String valores) {
        //PlanoAula novoPlanoAula = new PlanoAula(calendarioLetivo, oferecimento, planejamentoAula,bibliografiaBasica, bibliografiaComplementar, ementa, conceitos, conteudoProgramatico, criteriosAvaliacao, habilidades, metodologia, valores);
        //iplanoaula.criaPlanoAula(novoPlanoAula);
    }

    public List<PlanoAula> listaPlanosAulas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PlanoAula recuperaPlanoAula(String strEmenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizaPlanoAula(PlanoAula pa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removePlanoAula(PlanoAula pa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
