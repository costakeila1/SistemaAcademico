//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Faculdade;
import java.util.List;

public interface InterfaceFaculdade {

    public void criaFaculdade(Faculdade faculdade);

    public List<Faculdade> listaFaculdades();

    public Faculdade recuperaFaculdade(String cnpj);

    public void atualizaFaculdade(Faculdade faculdade);

    public void removeFaculdade(Faculdade faculdade);
}
