//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import java.util.List;

public interface InterfaceConsulta {

    public List<Oferecimento> buscaOferecimentosTurma(String strCodigoTurma);

    public List<Matricula> buscaMatriculasAluno(String tia);
}
