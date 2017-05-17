//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.PlanoAula;
import br.mackenzie.academico.excecao.CalendarioNaoEncontradoException;
import br.mackenzie.academico.excecao.OferecimentoNaoEncontradoException;
import br.mackenzie.academico.excecao.PlanoAulaNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfacePlanoAula;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerPlanoAula {

    private InterfacePlanoAula iPlanoAula;

    public ControllerPlanoAula() {
        iPlanoAula = (InterfacePlanoAula) Modelo.getInstance();
    }

    public void criaPlanoAula(String calendarioLetivo, String oferecimento, String planejamentoAula, String bibliografiaBasica, String bibliografiaComplementar, String ementa, String conceitos, String conteudoProgramatico, String criteriosAvaliacao, String habilidades, String metodologia, String valores) {
        //PlanoAula novoPlanoAula = new PlanoAula(calendarioLetivo, oferecimento, planejamentoAula,bibliografiaBasica, bibliografiaComplementar, ementa, conceitos, conteudoProgramatico, criteriosAvaliacao, habilidades, metodologia, valores);
        //iplanoaula.criaPlanoAula(novoPlanoAula);
    }

    public List<PlanoAula> listaPlanosAulas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PlanoAula recuperaPlanoAula(String cTurma, String cComponente) throws PlanoAulaNaoEncontradoException, OferecimentoNaoEncontradoException {
        Oferecimento oferecimento = iPlanoAula.recuperaOferecimento(cTurma, cComponente);
        return iPlanoAula.recuperaPlanoAula(oferecimento);
    }

    public void atualizaPlanoAula(PlanoAula pa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removePlanoAula(PlanoAula pa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Oferecimento recuperaOferecimento(String turma, String componente) throws OferecimentoNaoEncontradoException {
        return iPlanoAula.recuperaOferecimento(turma, componente);
    }

    public CalendarioLetivo recuperaCalendarioLetivo(String eventos) throws CalendarioNaoEncontradoException {
        return iPlanoAula.recuperaCalendarioLetivo(eventos);
    }

}
