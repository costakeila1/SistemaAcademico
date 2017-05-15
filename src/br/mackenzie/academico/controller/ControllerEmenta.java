//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.modelo.InterfaceEmenta;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerEmenta {
    
    private InterfaceEmenta iEmenta;
    
    public ControllerEmenta(){
        iEmenta = (InterfaceEmenta) Modelo.getInstance();
    }

    public void criaEmenta(String strCodigo, String strDescrição, String bBasica, String bComplementar) {
        Ementa novaEmenta = new Ementa(bBasica, bComplementar, strDescrição);
        novaEmenta.setCodigo(strCodigo);
        iEmenta.criaEmenta(novaEmenta);
    }

    public List<Ementa> listaEmentas() {
        return iEmenta.listaEmentas();
    }

    public Ementa recuperaEmenta(String strCodigo) {
        return iEmenta.recuperaEmenta(strCodigo);
    }

    public void removeEmenta(String strCodigo){
        iEmenta.removeEmenta(strCodigo);
    }

}
