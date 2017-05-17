//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.PlanoAula;
import br.mackenzie.academico.excecao.CalendarioNaoEncontradoException;
import br.mackenzie.academico.excecao.OferecimentoNaoEncontradoException;
import br.mackenzie.academico.excecao.PlanoAulaNaoEncontradoException;

public interface InterfacePlanoAula {

    public void criaPlanoAula(PlanoAula novoPlanoAula);

    public Oferecimento recuperaOferecimento(String turma, String componente) throws OferecimentoNaoEncontradoException;

    public CalendarioLetivo recuperaCalendarioLetivo(String eventos) throws CalendarioNaoEncontradoException;

    public PlanoAula recuperaPlanoAula(Oferecimento oferecimento) throws PlanoAulaNaoEncontradoException;
    
}
