//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.GradeCurricular;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.excecao.GradeCurricularNaoEncontradaException;
import br.mackenzie.academico.excecao.ProjetoPedagogicoNaoEncontradoException;
import java.util.List;

public interface InterfaceGradeCurricular {

    public void criaGradeCurricular(GradeCurricular novaGradeCurricular);

    public List<GradeCurricular> listaGradesCurriculares();

    public GradeCurricular recuperaGradeCurricular(String projetoPedagogico) throws GradeCurricularNaoEncontradaException;

    public void atualizaGradeCurricular(GradeCurricular gradeCurricular);

    public void removeGradeCurricular(GradeCurricular gradeCurricular);

    public ProjetoPedagogico recuperaProjetoPedagogico(String nomeCurso) throws ProjetoPedagogicoNaoEncontradoException;
    
}
