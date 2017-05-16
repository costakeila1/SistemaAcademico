//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerPlanoEnsino;
import br.mackenzie.academico.dominio.PlanoEnsino;
import br.mackenzie.academico.excecao.PlanoEnsinoNaoEncontradoException;
import br.mackenzie.academico.utils.Menu;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroPlanoEnsino {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo plano de ensino.",
        "_/_/     (2) Listar planos de ensino cadastradas.",
        "_/_/     (3) Atualizar Plano de Ensino.",
        "_/_/     (4) Remover plano de ensino do cadastro.",
        "_/_/     (0) Sai do plano de ensino.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;

        ControllerPlanoEnsino controllerPlanoEnsino = new ControllerPlanoEnsino();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroPlanoEnsino.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String descriçãoEmenta = menu.readInput("Entre com a descrição da ementa:");
                    String bBasica = menu.readInput("Entre com a bibliografia básica:");
                    String bComplementar = menu.readInput("Entre com a bibliografia complementar:");
                    String conceitos = menu.readInput("Entre com os conceitos do plano de ensino:");
                    String conteudoProgramatico = menu.readInput("Entre com o conteúdo programático:");
                    String criteriosAvaliacao = menu.readInput("Entre com os critérios de avaliação:");
                    String habilidades = menu.readInput("Entre com as habilidades:");
                    String metodologia = menu.readInput("Entre com a metogolodia:");
                    String valores = menu.readInput("Entre com os valores:");
                    controllerPlanoEnsino.criaPlanoEnsino(descriçãoEmenta, bBasica, bComplementar, conceitos, conteudoProgramatico, criteriosAvaliacao, habilidades, metodologia, valores);
                    break;
                }
                case "2":
                    System.out.println("Lista Planos de Ensino");
                    List<PlanoEnsino> planosEnsino = controllerPlanoEnsino.listaPlanosEnsino();
                    for (PlanoEnsino pe : planosEnsino) {
                        System.out.println(pe.getConceitos() + " : " + pe.getMetodologia());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String codigoEmenta = menu.readInput("Entre com o código da Ementa:");
                    PlanoEnsino pe = null;
                    try {
                        pe = controllerPlanoEnsino.recuperaPlanoEnsino(codigoEmenta);
                    } catch (PlanoEnsinoNaoEncontradoException ex) {
                        Logger.getLogger(CadastroPlanoEnsino.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (pe != null) {
                        String conceitos = menu.readInput("Entre com os conceitos do plano de ensino:");
                        String conteudoProgramatico = menu.readInput("Entre com o conteúdo programático:");
                        String criteriosAvaliacao = menu.readInput("Entre com os critérios de avaliação:");
                        String habilidades = menu.readInput("Entre com as habilidades:");
                        String metodologia = menu.readInput("Entre com a metogolodia:");
                        String valores = menu.readInput("Entre com os valores:");
                        pe.setConceitos(conceitos);
                        pe.setConteudoProgramatico(conteudoProgramatico);
                        pe.setCriteriosAvaliacao(criteriosAvaliacao);
                        pe.setHabilidades(habilidades);
                        pe.setMetodologia(metodologia);
                        pe.setValores(valores);
                        controllerPlanoEnsino.atualizaPlanoEnsino(pe);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String codigoEmenta = menu.readInput("Entre com o código da Ementa:");
                    PlanoEnsino pe = null;
                    try {
                        pe = controllerPlanoEnsino.recuperaPlanoEnsino(codigoEmenta);
                    } catch (PlanoEnsinoNaoEncontradoException ex) {
                        Logger.getLogger(CadastroPlanoEnsino.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (pe != null) {
                        String strConf = menu.readInput("Deseja realmente remover o plano de ensino do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerPlanoEnsino.removePlanoEnsino(pe);
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
