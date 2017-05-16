//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceTurma;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerTurma {

    private InterfaceTurma iturma;

    public ControllerTurma() {
        iturma = (InterfaceTurma) Modelo.getInstance();
    }

    public void criaTurma(String strNome, String strCodigo, String strPeriodo) throws CursoNaoEncontradoException {
        Turma novaTurma = new Turma(iturma.recuperaCurso(strNome));
        novaTurma.setCodigo(strCodigo);
        novaTurma.setPeriodoDeIngresso(strPeriodo);
        iturma.criaTurma(novaTurma);
    }

    public List<Turma> listaTurmas() {
        return iturma.listaTurmas();
    }

    public Turma recuperaTurma(String codigo) {
        return iturma.recuperaTurma(codigo);
    }

    public void atualizaTurma(Turma turma) {
        iturma.atualizaTurma(turma);
    }

    public void removeTurma(Turma turma) {
        iturma.removeTurma(turma);
    }
}
