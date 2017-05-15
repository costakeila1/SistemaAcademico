//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.Turma;
import java.util.List;

public interface InterfaceTurma {

    public void criaTurma(Turma turma);

    public List<Turma> listaTurmas();

    public Turma recuperaTurma(String codigo);

    public void atualizaTurma(Turma turma);

    public void removeTurma(Turma turma);

    public Curso recuperaCurso(String strNome);
}
