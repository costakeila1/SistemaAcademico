//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceComponenteCurricular;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerComponenteCurricular {

    private InterfaceComponenteCurricular iComponente;

    public ControllerComponenteCurricular() {
        iComponente = (InterfaceComponenteCurricular) Modelo.getInstance();
    }

    public void criaComponenteCurricular(String strCodigo, String strNome, String codEmenta) {
        Ementa ementa = iComponente.recuperaEmenta(codEmenta);
        ComponenteCurricular novoComponente = new ComponenteCurricular(ementa);
        novoComponente.setCodigo(strCodigo);
        novoComponente.setNome(strNome);
        iComponente.criaComponenteCurricular(novoComponente);
    }

    public List<ComponenteCurricular> listaComponentesCurriculares() {
        return iComponente.listaComponentesCurriculares();
    }

    public ComponenteCurricular recuperaComponenteCurricular(String codigo) throws ComponenteCurricularNaoEncontradoException{
        return iComponente.recuperaComponenteCurricular(codigo);
    }

    public void atualizaComponenteCurricular(ComponenteCurricular c, String strNome, String codEmenta) {
        Ementa ementa = iComponente.recuperaEmenta(codEmenta);
        c.setNome(strNome);
        c.setEmenta(ementa);
        iComponente.atualizaComponenteCurricular(c);
    }

    public void removeComponenteCurricular(ComponenteCurricular componente) {
        iComponente.removeComponenteCurricular(componente);
    }
}
