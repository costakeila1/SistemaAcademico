//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerProfessor;
import br.mackenzie.academico.dominio.Professor;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroProfessor {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar nova Faculdade.",
        "_/_/     (2) Listar Faculdades cadastradas.",
        "_/_/     (3) Atualizar Faculdade.",
        "_/_/     (4) Remover faculdade do cadastro.",
        "_/_/     (0) Sai da faculdade.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;

        ControllerProfessor controllerProfessor = new ControllerProfessor();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroProfessor.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String nome = menu.readInput("Entre com o nome do professor:");
                    String drt = menu.readInput("Entre com o DRT do professor:");
                    String codComponente = menu.readInput("Entre com o código do componente curricular");
                    String codTurma = menu.readInput("Entre com o código da turma");
                    controllerProfessor.criaProfessor(nome, drt, codComponente, codTurma);
                    break;
                }
                case "2":
                    System.out.println("Lista faculdades");
                    List<Professor> professores = controllerProfessor.listaProfessores();
                    for (Professor p : professores) {
                        System.out.println(p.getNome() + ":" + p.getDRT() + ":" + p.getOferecimento().getComponenteCurricular().getNome());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String drt = menu.readInput("Entre com o DRT do professor:");
                    Professor p = controllerProfessor.recuperaProfessor(drt);
                    if (p != null) {
                        String nome = menu.readInput("Entre com o novo nome [" + p.getNome() + "]:");
                        String codComponente = menu.readInput("Entre com o código do componente curricular");
                        String codTurma = menu.readInput("Entre com o código da turma");
                        p.setNome(nome);
                        controllerProfessor.atualizaProfessor(p, codComponente, codTurma);

                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String drt = menu.readInput("Entre com o DRT do professor:");
                    Professor p = controllerProfessor.recuperaProfessor(drt);
                    if (p != null) {
                        System.out.println(p.getNome() + ":" + p.getDRT());
                        String strConf = menu.readInput("Deseja realmente remover o professor do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerProfessor.removeProfessor(p);
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
