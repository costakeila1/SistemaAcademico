//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import br.mackenzie.academico.excecao.EmentaNaoEnconradaException;
import br.mackenzie.academico.modelo.InterfaceComponenteCurricular;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerComponenteCurricular {

    private InterfaceComponenteCurricular iComponente;

    public ControllerComponenteCurricular() {
        iComponente = (InterfaceComponenteCurricular) Modelo.getInstance();
    }

    public void criaComponenteCurricular(String strCodigo, String strNome, String codEmenta) {
        Ementa ementa = null;
        try {
            ementa = iComponente.recuperaEmenta(codEmenta);
        } catch (EmentaNaoEnconradaException ex) {
            Logger.getLogger(ControllerComponenteCurricular.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComponenteCurricular novoComponente = new ComponenteCurricular(ementa);
        novoComponente.setCodigo(strCodigo);
        novoComponente.setNome(strNome);
        iComponente.criaComponenteCurricular(novoComponente);
    }

    public List<ComponenteCurricular> listaComponentesCurriculares() {
        return iComponente.listaComponentesCurriculares();
    }

    public ComponenteCurricular recuperaComponenteCurricular(String codigo) throws ComponenteCurricularNaoEncontradoException {
        return iComponente.recuperaComponenteCurricular(codigo);
    }

    public void atualizaComponenteCurricular(ComponenteCurricular c, String strNome, String codEmenta) {
        Ementa ementa = null;
        try {
            ementa = iComponente.recuperaEmenta(codEmenta);
        } catch (EmentaNaoEnconradaException ex) {
            Logger.getLogger(ControllerComponenteCurricular.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setNome(strNome);
        c.setEmenta(ementa);
        iComponente.atualizaComponenteCurricular(c);
    }

    public void removeComponenteCurricular(ComponenteCurricular componente) {
        iComponente.removeComponenteCurricular(componente);
    }
}
