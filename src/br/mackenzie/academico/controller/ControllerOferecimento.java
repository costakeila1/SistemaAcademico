//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import br.mackenzie.academico.excecao.OferecimentoNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceOferecimento;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerOferecimento {
    
    private InterfaceOferecimento ioferecimento;
    
    public ControllerOferecimento (){
        ioferecimento = (InterfaceOferecimento) Modelo.getInstance();
    }
    
    public void criaOferecimento(String strCodigoTurma, String strCodigoComponente, String strInformacaoAdicional) throws ComponenteCurricularNaoEncontradoException{
         Turma t = ioferecimento.recuperaTurma(strCodigoTurma);
         ComponenteCurricular c = ioferecimento.recuperaComponenteCurricular(strCodigoComponente);
         Oferecimento novoOferecimento= new Oferecimento(t,c);
         novoOferecimento.setInformacoesAdicionais(strInformacaoAdicional);
         ioferecimento.criaOferecimento(novoOferecimento);
    }
    
    public List<Oferecimento> listaOferecimentos(){
        return ioferecimento.listaOferecimentos();
    }
    
    public Oferecimento recuperaOferecimento(String codigoTurma, String codigoComponenteCurricular) throws OferecimentoNaoEncontradoException{
        return ioferecimento.recuperaOferecimento(codigoTurma,codigoComponenteCurricular);
    }
    
    public void atualizaOferecimento(Oferecimento oferecimento){
        ioferecimento.atualizaOferecimento(oferecimento);
    }
    
    public void removeOferecimento(Oferecimento oferecimento){
        ioferecimento.removeOferecimento(oferecimento);
    }
}
