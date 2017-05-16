//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerProjetoPedagogico;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.excecao.ProjetoPedagogicoNaoEncontradoException;
import br.mackenzie.academico.utils.Menu;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroProjetoPedagogico {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Projeto Pedagogio.",
        "_/_/     (2) Listar Projetos Cadastrados.",
        "_/_/     (3) Atualizar Projeto.",
        "_/_/     (4) Remover projeto do cadastro.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;

        ControllerProjetoPedagogico controllerProjetoPedagogico = new ControllerProjetoPedagogico();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroProjetoPedagogico.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String curso = menu.readInput("Entre com o nome do curso:");
                    String justificativa = menu.readInput("Entre com a justificativa:");
                    String perfil = menu.readInput("Entre com o perfil:");
                    try {
                        controllerProjetoPedagogico.criaProjetoPedagogico(justificativa, perfil, curso);
                    } catch (CursoNaoEncontradoException ex) {
                        Logger.getLogger(CadastroProjetoPedagogico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "2":
                    System.out.println("Lista Projetos Pedagógicos");
                    List<ProjetoPedagogico> projetosPedagogicos = controllerProjetoPedagogico.listaProjetosPedagogicos();
                    for (ProjetoPedagogico p : projetosPedagogicos) {
                        System.out.println(p.getCurso().getNome() + " : " + p.getPerfil() + " : " + p.getJustificativa());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String nomeCurso = menu.readInput("Entre com o nome do curso:");
                    ProjetoPedagogico p = null;
                    try {
                        p = controllerProjetoPedagogico.recuperaProjetoPedagogico(nomeCurso);
                    } catch (ProjetoPedagogicoNaoEncontradoException ex) {
                        Logger.getLogger(CadastroProjetoPedagogico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (p != null) {
                        String justificativa = menu.readInput("Entre com a nova justificativa:");
                        String perfil = menu.readInput("Entre com o novo perfil:");
                        p.setJustificativa(justificativa);
                        p.setPerfil(perfil);
                        controllerProjetoPedagogico.atualizaProjetoPedagogico(p);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String nomeCurso = menu.readInput("Entre com o nome do curso:");
                    ProjetoPedagogico p = null;
                    try {
                        p = controllerProjetoPedagogico.recuperaProjetoPedagogico(nomeCurso);
                    } catch (ProjetoPedagogicoNaoEncontradoException ex) {
                        Logger.getLogger(CadastroProjetoPedagogico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (p != null) {
                        System.out.println(p.getCurso().getNome() + " : " + p.getPerfil() + " : " + p.getJustificativa());
                        String strConf = menu.readInput("Deseja realmente remover o projeto pedagógico (S/N):");
                        if (strConf.equals("S")) {
                            controllerProjetoPedagogico.removeProjetoPedagogico(p);
                        }
                    }
                    break;
                }
                case "0":
                    runMenuPrincipal = false;
                    break;
                default:
                    System.out.println("Entrada Invalida");
                    break;
            }
        }
    }
}
