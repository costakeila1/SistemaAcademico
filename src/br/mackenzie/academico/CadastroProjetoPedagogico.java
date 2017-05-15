//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerProjetoPedagogico;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

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
                    String strNome = menu.readInput("Entre com o nome do curso:");
                    String strCodigo = menu.readInput("Entre com o codigo da turma:");
                    String strPeriodo = menu.readInput("Entre com o periodo de ingresso:");
                    controllerProjetoPedagogico.criaProjetoPedagogico(strNome, strCodigo, strPeriodo);
                    break;
                }
                case "2":
                    System.out.println("Lista Projetos Pedagógicos");
                    List<ProjetoPedagogico> projetosPedagogicos = controllerProjetoPedagogico.listaProjetosPedagogicos();
                    for (ProjetoPedagogico p : projetosPedagogicos) {
                        //System.out.println(t.getCodigo() + ":" + t.getPeriodoDeIngresso() + ":" + t.getCurso().getNome());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String strCodigo = menu.readInput("Entre com o codigo da Turma:");
                    ProjetoPedagogico p = controllerProjetoPedagogico.recuperaProjetoPedagogico(strCodigo);
                    if (p != null) {
                        //String strPeriodo = menu.readInput("Entre com o novo periodo [" + t.getPeriodoDeIngresso() + "]:");
                        //t.setPeriodoDeIngresso(strPeriodo);
                        //controllerTurma.atualizaTurma(t);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strCodigo = menu.readInput("Entre com o codigo da turma:");
                    ProjetoPedagogico p = controllerProjetoPedagogico.recuperaProjetoPedagogico(strCodigo);
                    if (p != null) {
                        //System.out.println(t.getCodigo() + ":" + t.getCurso().getNome());
                        //String strConf = menu.readInput("Deseja realmente remover a turma do cadastro (S/N):");
                        //if (strConf.equals("S")) {
                        //    controllerTurma.removeTurma(t);
                        //}
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
