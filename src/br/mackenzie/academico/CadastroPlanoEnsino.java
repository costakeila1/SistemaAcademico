//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerOferecimento;
import br.mackenzie.academico.dominio.Oferecimento;
<<<<<<< HEAD
=======
import br.mackenzie.academico.modelo.Modelo;
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroPlanoEnsino {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo plano de ensino.",
        "_/_/     (2) Listar planos de ensino cadastradas.",
        "_/_/     (3) Alterar plano de ensino cadastrado.",
        "_/_/     (4) Remover plano de ensino do cadastro.",
        "_/_/     (0) Sai do plano de ensino.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerOferecimento controllerOferecimento = new ControllerOferecimento();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroPlanoEnsino.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strCodigoTurma = menu.readInput("Entre com o codigo da turma:");
                    String strCodigoComponente = menu.readInput("Entre com o codigo do componente curricular:");
                    String strInformacaoAdicional = menu.readInput("Entre com informacoes adicionais:");
                    controllerOferecimento.criaOferecimento(strCodigoTurma, strCodigoComponente, strInformacaoAdicional);
                    break;
                }
                case "2":
                    System.out.println("Lista Oferecimento");
                    List<Oferecimento> oferecimentos = controllerOferecimento.listaOferecimentos();
                    for (Oferecimento o : oferecimentos) {
                        System.out.println(o.getComponenteCurricular().getCodigo() + ":" + o.getTurma().getCodigo() + ":" + o.getInformacoesAdicionais());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String strCodigoTurma = menu.readInput("Entre com o codigo da turma:");
                    String strCodigoComponente = menu.readInput("Entre com o codigo do componente curricular:");
                    Oferecimento o = controllerOferecimento.recuperaOferecimento(strCodigoTurma, strCodigoComponente);
                    if (o != null) {
                        String strInfoAdicional = menu.readInput("Entre com informacoes adicionais [" + o.getInformacoesAdicionais() + "]:");
                        o.setInformacoesAdicionais(strInfoAdicional);
                        controllerOferecimento.atualizaOferecimento(o);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strCodigoTurma = menu.readInput("Entre com o codigo da turma:");
                    String strCodigoComponente = menu.readInput("Entre com o codigo do componente curricular:");
                    Oferecimento o = controllerOferecimento.recuperaOferecimento(strCodigoTurma, strCodigoComponente);
                    if (o != null) {
                        System.out.println(o.getTurma().getCodigo() + ":" + o.getComponenteCurricular().getCodigo());
                        String strConf = menu.readInput("Deseja realmente remover o oferecimento do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerOferecimento.removeOferecimento(o);
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