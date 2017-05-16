//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.PlanoEnsino;
import br.mackenzie.academico.excecao.PlanoEnsinoNaoEncontradoException;
import java.util.List;

public interface InterfacePlanoEnsino {

    public void criaPlanoEnsino(PlanoEnsino novoPlanoEnsino);

    public List<PlanoEnsino> listaPlanos();

    public PlanoEnsino recuperaPlanoEnsino(String Ementa) throws PlanoEnsinoNaoEncontradoException;

    public void atualizaPlanoEnsino(PlanoEnsino planoEnsino);

    public void removePlanoEnsino(PlanoEnsino planoEnsino);

}
