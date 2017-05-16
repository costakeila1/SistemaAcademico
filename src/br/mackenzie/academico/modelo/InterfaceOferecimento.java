//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import br.mackenzie.academico.excecao.OferecimentoNaoEncontradoException;
import java.util.List;

public interface InterfaceOferecimento {

    public void criaOferecimento(Oferecimento oferecimento);

    public List<Oferecimento> listaOferecimentos();

    public Oferecimento recuperaOferecimento(String codigoTurma, String codigoComponenteCurricular) throws OferecimentoNaoEncontradoException ;

    public void atualizaOferecimento(Oferecimento oferecimento);

    public void removeOferecimento(Oferecimento oferecimento);

    public Turma recuperaTurma(String strCodigoTurma);

    public ComponenteCurricular recuperaComponenteCurricular(String strCodigoComponente) throws ComponenteCurricularNaoEncontradoException;
}
