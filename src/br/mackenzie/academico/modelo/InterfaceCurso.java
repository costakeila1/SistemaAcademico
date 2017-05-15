//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.Faculdade;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import java.util.List;

public interface InterfaceCurso {

    public void criaCurso(Curso curso);

    public List<Curso> listaCursos();

    public Curso recuperaCurso(String nome);

    public void atualizaCurso(Curso curso);

    public void removeCurso(Curso curso);

    public Faculdade recuperaFaculdade(String strCnpj) throws FaculdadeNaoEncontradaException;;
}
