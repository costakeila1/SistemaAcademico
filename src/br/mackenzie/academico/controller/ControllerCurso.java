//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import br.mackenzie.academico.modelo.InterfaceCurso;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerCurso {
    
    private InterfaceCurso iCurso;
    
    public ControllerCurso(){
        iCurso = (InterfaceCurso) Modelo.getInstance();
    }

    public void criaCurso(String strCnpj, String strNome) throws FaculdadeNaoEncontradaException {
        Curso novoCurso = new Curso(iCurso.recuperaFaculdade(strCnpj));
        novoCurso.setNome(strNome);
        iCurso.criaCurso(novoCurso);
    }

    public List<Curso> listaCursos() {
        return iCurso.listaCursos();
    }

    public Curso recuperaCurso(String cpnj) throws CursoNaoEncontradoException {
        return iCurso.recuperaCurso(cpnj);
    }

    public void atualizaCurso(Curso curso) {
        iCurso.atualizaCurso(curso);
    }

    public void removeCurso(Curso curso) {
        iCurso.removeCurso(curso);
    }

}
