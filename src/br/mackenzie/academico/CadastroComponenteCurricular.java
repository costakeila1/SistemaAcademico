//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerComponenteCurricular;
import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroComponenteCurricular {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Componente Curricular.",
        "_/_/     (2) Listar Componentes Curriculares cadastrados.",
        "_/_/     (3) Atualizar Componente Curricular.",
        "_/_/     (4) Remover Componente Curricular do cadastro.",
        "_/_/     (0) Sai do componente.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerComponenteCurricular controllerComponenteCurricular = new ControllerComponenteCurricular();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroComponenteCurricular.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strCodigo = menu.readInput("Entre com o Código do Componente Curricular:");
                    String strNome = menu.readInput("Entre com o Nome do Componente Curricular:");
                    String codEmenta = menu.readInput("Entre com o texto da ementa:");
                    controllerComponenteCurricular.criaComponenteCurricular(strCodigo, strNome, codEmenta);
                    break;
                }
                case "2":
                    System.out.println("Lista Componentes Curriculares");
                    List<ComponenteCurricular> componentes = controllerComponenteCurricular.listaComponentesCurriculares();
                    for (ComponenteCurricular c : componentes) {
                        System.out.println(c.getCodigo() + ":" + c.getNome());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String strCodigo = menu.readInput("Entre com o Codigo do Componente Curricular:");
                    ComponenteCurricular c = null;
                    try {
                        c = controllerComponenteCurricular.recuperaComponenteCurricular(strCodigo);
                    } catch (ComponenteCurricularNaoEncontradoException ex) {
                        System.out.println("Componente curricular não foi encontrado com o código:" + strCodigo);
                    }
                    if (c != null) {
                        String strNome = menu.readInput("Entre com o novo nome [" + c.getNome() + "]:");
                        String codEmenta = menu.readInput("Entre com o codigo da nova ementa: ");
                        controllerComponenteCurricular.atualizaComponenteCurricular(c, strNome, codEmenta);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strCodigo = menu.readInput("Entre com o Codigo do Componente Curricular:");
                    ComponenteCurricular c = null;
                    try {
                        c = controllerComponenteCurricular.recuperaComponenteCurricular(strCodigo);
                    } catch (ComponenteCurricularNaoEncontradoException ex) {
                        System.out.println("Componente curricular não foi encontrado com o código:" + strCodigo);
                    }
                    if (c != null) {
                        System.out.println(c.getCodigo() + ":" + c.getNome());
                        String strConf = menu.readInput("Deseja realmente remover o componente do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerComponenteCurricular.removeComponenteCurricular(c);
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
