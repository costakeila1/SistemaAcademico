//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import java.util.List;

public interface InterfaceComponenteCurricular {

    public void criaComponenteCurricular(ComponenteCurricular componente);

    public List<ComponenteCurricular> listaComponentesCurriculares();

    public ComponenteCurricular recuperaComponenteCurricular(String codigo) throws ComponenteCurricularNaoEncontradoException;

    public void atualizaComponenteCurricular(ComponenteCurricular componente);

    public void removeComponenteCurricular(ComponenteCurricular componente);

    public Ementa recuperaEmenta(String codEmenta);
}
