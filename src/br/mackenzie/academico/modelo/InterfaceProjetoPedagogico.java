//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import java.util.List;

public interface InterfaceProjetoPedagogico {

    public Curso recuperaCurso(String cursoNome);

    public void criaProjetoPedagogico(ProjetoPedagogico projeto);

    public List<ProjetoPedagogico> listaProjetosPedagogicos();
    
    public ProjetoPedagogico recuperaProjetoPedagogico(String nomeCurso);
    
    public void removeProjetoPedagogico(ProjetoPedagogico p);

    public void atualizaProjetoPedagogico(ProjetoPedagogico p);
    
}
