//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Faculdade;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import br.mackenzie.academico.modelo.InterfaceFaculdade;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerFaculdade {

    private InterfaceFaculdade iFaculdade;

    public ControllerFaculdade() {
        iFaculdade = (InterfaceFaculdade) Modelo.getInstance();
    }

    public void criaFaculdade(String strCnpj, String strEndereco, String strNome, String strTelefone) {
        Faculdade novaFaculdade = new Faculdade(strCnpj, strEndereco, strNome, strTelefone);
        iFaculdade.criaFaculdade(novaFaculdade);
    }

    public List<Faculdade> listaFaculdades() {
        return iFaculdade.listaFaculdades();
    }

    public Faculdade recuperaFaculdade(String cpnj) throws FaculdadeNaoEncontradaException {
        return iFaculdade.recuperaFaculdade(cpnj);
    }

    public void atualizaFaculdade(Faculdade faculdade) {
        iFaculdade.atualizaFaculdade(faculdade);
    }

    public void removeFaculdade(Faculdade faculdade) {
        iFaculdade.removeFaculdade(faculdade);
    }

}
