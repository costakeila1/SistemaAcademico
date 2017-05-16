//[315.31.89-1] Keila Lopes Costa
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.modelo.InterfaceProjetoPedagogico;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerProjetoPedagogico {

    private InterfaceProjetoPedagogico iProjetoPedagogico;

    public ControllerProjetoPedagogico() {
        iProjetoPedagogico = (InterfaceProjetoPedagogico) Modelo.getInstance();
    }

    public void criaProjetoPedagogico(String justificativa, String perfil, String cursoNome) {
        Curso curso = iProjetoPedagogico.recuperaCurso(cursoNome);
        ProjetoPedagogico projeto = new ProjetoPedagogico(justificativa, perfil, curso);
        iProjetoPedagogico.criaProjetoPedagogico(projeto);
    }

    public List<ProjetoPedagogico> listaProjetosPedagogicos() {
        return iProjetoPedagogico.listaProjetosPedagogicos();
    }

    public ProjetoPedagogico recuperaProjetoPedagogico(String nomeCurso) {
        return iProjetoPedagogico.recuperaProjetoPedagogico(nomeCurso);
    }

    public void atualizaProjetoPedagogico(ProjetoPedagogico p) {
        iProjetoPedagogico.atualizaProjetoPedagogico(p);
    }

    public void removeProjetoPedagogico(ProjetoPedagogico p) {
        iProjetoPedagogico.removeProjetoPedagogico(p);    }

}
