//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.GradeCurricular;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.excecao.GradeCurricularNaoEncontradaException;
import br.mackenzie.academico.excecao.ProjetoPedagogicoNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceGradeCurricular;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerGradeCurricular {
    
    private InterfaceGradeCurricular iGradeCurricular;
    
    public ControllerGradeCurricular(){
        iGradeCurricular = (InterfaceGradeCurricular) Modelo.getInstance();
    }

    public void criaGradeCurricular(String nomeCurso, String informacoes) throws ProjetoPedagogicoNaoEncontradoException {
        ProjetoPedagogico p = iGradeCurricular.recuperaProjetoPedagogico(nomeCurso);
        GradeCurricular novaGradeCurricular= new GradeCurricular(p);
        novaGradeCurricular.setInformacoes(informacoes);
        iGradeCurricular.criaGradeCurricular(novaGradeCurricular);
    }

    public List<GradeCurricular> listaGradesCurriculares() {
        return iGradeCurricular.listaGradesCurriculares();
    }

    public GradeCurricular recuperaGradeCurricular(String projetoPedagogico) throws GradeCurricularNaoEncontradaException {
        return iGradeCurricular.recuperaGradeCurricular(projetoPedagogico);
    }

    public void atualizaGradeCurricular(GradeCurricular gradeCurricular) {
        iGradeCurricular.atualizaGradeCurricular(gradeCurricular);
    }

    public void removeGradeCurricular(GradeCurricular gradeCurricular) {
        iGradeCurricular.removeGradeCurricular(gradeCurricular);
    }
}