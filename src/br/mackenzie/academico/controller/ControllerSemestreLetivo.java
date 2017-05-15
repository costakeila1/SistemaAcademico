//[315.31.89-1] Keila Lopes Costa
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.SemestreLetivo;
import br.mackenzie.academico.excecao.SemestreLetivoNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceSemestreLetivo;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerSemestreLetivo {
    
    private InterfaceSemestreLetivo iSemestreLetivo;
    
    public ControllerSemestreLetivo(){
        iSemestreLetivo = (InterfaceSemestreLetivo) Modelo.getInstance();
    }

    public void criaSemestreLetivo(int ano, int semestre) {
        SemestreLetivo novoSemestre = new SemestreLetivo(ano, semestre);
        iSemestreLetivo.criaSemestreLetivo(novoSemestre);
    }

    public List<SemestreLetivo> listaSemestresLetivos() {
        return iSemestreLetivo.listaSemestresLetivos();
    }

    public SemestreLetivo recuperaSemestreLetivo(int ano, int semestre) throws SemestreLetivoNaoEncontradoException{
        return iSemestreLetivo.recuperaSemestreLetivo(ano, semestre);
    }

    public void atualizaSemestreLetivo(int ano, int semestre) {
        iSemestreLetivo.atualizaSemestreLetivo(ano, semestre);
    }

    public void removeSemestreLetivo(SemestreLetivo s) {
        iSemestreLetivo.removeSemestreLetivo(s);
    }
    
}
