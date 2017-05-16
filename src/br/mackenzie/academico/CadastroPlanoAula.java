//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerPlanoAula;
import br.mackenzie.academico.dominio.PlanoAula;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroPlanoAula {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Plano de Aula.",
        "_/_/     (2) Listar Planos cadastrados.",
        "_/_/     (3) Atualizar Plano de Aula.",
        "_/_/     (4) Remover Plano de Aula do cadastro.",
        "_/_/     (5) Salva o modelo.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerPlanoAula controllerPlanoAula = new ControllerPlanoAula();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroPlanoAula.menuPrincipal);
            String str = menu.readInput("Sua escolha:");

            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strBibliografiaBasica = menu.readInput("Entre com a Bibliografia básica:");
                    String strBibliografiaComplementar = menu.readInput("Entre com a Bibliografia complementar:");
                    String strEmenta = menu.readInput("Entre com a ementa:");
                    String strConceitos = menu.readInput("Entre com os conceitos básicos:");
                    String strConteudoProgramatico = menu.readInput("Entre com o conteúdo programatico:");
                    String strCriteriosAvaliacao = menu.readInput("Entre com os critérios de avaliação:");
                    String strHabilidades = menu.readInput("Entre as Habilidades:");
                    String strMetodologia = menu.readInput("Entre com a metodologia:");
                    String strValores = menu.readInput("Entre com os valores:");
                    String strCalendarioLetivo = menu.readInput("Entre com o calendário:");
                    String strPlanejamentoAula = menu.readInput("Entre com o planejamento da aula:");
                    String strOferecimento = menu.readInput("Entre com o Oferecimento:");
                    controllerPlanoAula.criaPlanoAula(strCalendarioLetivo, strOferecimento, strPlanejamentoAula, strBibliografiaBasica, strBibliografiaComplementar, strEmenta, strConceitos, strConteudoProgramatico, strCriteriosAvaliacao, strHabilidades, strMetodologia, strValores);
                    break;
                }
                case "2":
                    System.out.println("Lista Planos de Aula");
                    List<PlanoAula> planosAulas = controllerPlanoAula.listaPlanosAulas();
                    for (PlanoAula pa : planosAulas) {
                        System.out.println(pa.getBibliografiaBasica() + ":" + pa.getBibliografiaComplementar());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza Planos de Ensino");
                    String strEmenta = menu.readInput("Entre com a ementa:");
                    PlanoAula pa = controllerPlanoAula.recuperaPlanoAula(strEmenta);
                    if (pa != null) {
                        String strCalendarioLetivo = menu.readInput("Entre com os novos calendarios [" + pa.getCalendarioLetivo() + "]:");
                        String strOferecimento = menu.readInput("Entre com o novo oferecimento [" + pa.getConteudoProgramatico() + "]:");
                        String strPlanejamentoAula = menu.readInput("Entre com os novos critérios [" + pa.getPlanejamentoAula() + "]:");
                        pa.setPlanejamentoAula(strPlanejamentoAula);
                        controllerPlanoAula.atualizaPlanoAula(pa);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strEmenta = menu.readInput("Entre com a Ementa do plano de ensino:");
                    PlanoAula pa = controllerPlanoAula.recuperaPlanoAula(strEmenta);
                    if (pa != null) {
                        System.out.println(pa.getBibliografiaBasica() + ":" + pa.getBibliografiaComplementar());
                        String strConf = menu.readInput("Deseja realmente remover o Aluno do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerPlanoAula.removePlanoAula(pa);
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