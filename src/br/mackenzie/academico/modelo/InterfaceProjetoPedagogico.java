//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.excecao.ProjetoPedagogicoNaoEncontradoException;
import java.util.List;

public interface InterfaceProjetoPedagogico {

    public Curso recuperaCurso(String cursoNome) throws CursoNaoEncontradoException;

    public void criaProjetoPedagogico(ProjetoPedagogico projeto);

    public List<ProjetoPedagogico> listaProjetosPedagogicos();
    
    public ProjetoPedagogico recuperaProjetoPedagogico(String nomeCurso) throws ProjetoPedagogicoNaoEncontradoException;
    
    public void removeProjetoPedagogico(ProjetoPedagogico p);

    public void atualizaProjetoPedagogico(ProjetoPedagogico p);
    
}
