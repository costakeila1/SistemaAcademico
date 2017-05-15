//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Faculdade;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import java.util.List;

public interface InterfaceFaculdade {

    public void criaFaculdade(Faculdade faculdade);

    public List<Faculdade> listaFaculdades();

    public Faculdade recuperaFaculdade(String cnpj) throws FaculdadeNaoEncontradaException;;

    public void atualizaFaculdade(Faculdade faculdade);

    public void removeFaculdade(Faculdade faculdade);
}
