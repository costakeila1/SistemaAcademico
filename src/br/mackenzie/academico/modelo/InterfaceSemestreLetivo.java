//[315.31.89-1] Keila Lopes Costa
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.SemestreLetivo;
import java.util.List;

public interface InterfaceSemestreLetivo {

    public void criaSemestreLetivo(SemestreLetivo novoSemestre);

    public List<SemestreLetivo> listaSemestresLetivos();

    public SemestreLetivo recuperaSemestreLetivo(int ano, int semestre);

    public void atualizaSemestreLetivo(int ano, int semestre);

    public void removeSemestreLetivo(SemestreLetivo s);
    
}
