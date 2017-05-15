//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Faculdade;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import br.mackenzie.academico.modelo.InterfaceFaculdade;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerFaculdade {

    private InterfaceFaculdade ifaculdade;

    public ControllerFaculdade() {
        ifaculdade = (InterfaceFaculdade) Modelo.getInstance();
    }

    public void criaFaculdade(String strCnpj, String strEndereco, String strNome, String strTelefone) {
        Faculdade novaFaculdade = new Faculdade(strCnpj, strEndereco, strNome, strTelefone);
        ifaculdade.criaFaculdade(novaFaculdade);
    }

    public List<Faculdade> listaFaculdades() {
        return ifaculdade.listaFaculdades();
    }

    public Faculdade recuperaFaculdade(String cpnj) throws FaculdadeNaoEncontradaException {
        return ifaculdade.recuperaFaculdade(cpnj);
    }

    public void atualizaFaculdade(Faculdade faculdade) {
        ifaculdade.atualizaFaculdade(faculdade);
    }

    public void removeFaculdade(Faculdade faculdade) {
        ifaculdade.removeFaculdade(faculdade);
    }

}
