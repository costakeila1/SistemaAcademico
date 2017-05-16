//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import br.mackenzie.academico.modelo.InterfaceCurso;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerCurso {
    
    private InterfaceCurso icurso;
    
    public ControllerCurso(){
        icurso = (InterfaceCurso) Modelo.getInstance();
    }

    public void criaCurso(String strCnpj, String strNome) throws FaculdadeNaoEncontradaException {
        Curso novoCurso = new Curso(icurso.recuperaFaculdade(strCnpj));
        novoCurso.setNome(strNome);
        icurso.criaCurso(novoCurso);
    }

    public List<Curso> listaCursos() {
        return icurso.listaCursos();
    }

    public Curso recuperaCurso(String cpnj) throws CursoNaoEncontradoException {
        return icurso.recuperaCurso(cpnj);
    }

    public void atualizaCurso(Curso curso) {
        icurso.atualizaCurso(curso);
    }

    public void removeCurso(Curso curso) {
        icurso.removeCurso(curso);
    }

}
