package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Ementa;
import java.util.List;

public interface InterfaceEmenta {

    public void criaEmenta(Ementa novaEmenta);

    public List<Ementa> listaEmentas();

    public Ementa recuperaEmenta(String codigo);

    public void removeEmenta(String codigo);

}
