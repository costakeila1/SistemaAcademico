//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerEmenta;
import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroEmenta {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar nova Ementa.",
        "_/_/     (2) Listar Ementas cadastradas.",
        "_/_/     (3) Remover ementa do cadastro.",
        "_/_/     (3) Atualizar Ementa.",
        "_/_/     (4) Remover ementa do cadastro.",
        "_/_/     (0) Sai da ementa.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerEmenta controllerEmenta = new ControllerEmenta();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroEmenta.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strCodigo = menu.readInput("Entre com o codigo da ementa:");
                    String strDescrição = menu.readInput("Entre com a descrição da ementa:");
                    String bBasica = menu.readInput("Entre com a bibliografia básica:");
                    String bComplementar = menu.readInput("Entre com a bibliografia complementar:");
                    controllerEmenta.criaEmenta(strCodigo, strDescrição, bBasica, bComplementar);
                    break;
                }
                case "2":
                    System.out.println("Lista Ementa");
                    List<Ementa> ementas = controllerEmenta.listaEmentas();
                    for (Ementa e : ementas) {
                        System.out.println(e.getCodigo());
                        System.out.println(e.getDescrição());
                        System.out.println(e.getBibliografiaBasica());
                        System.out.println(e.getBibliografiaComplementar());
                    }
                    break;
                case "3": {
                    System.out.println("Remove");
                    String strCodigo = menu.readInput("Entre com o codigo da ementa:");
                    Ementa e = controllerEmenta.recuperaEmenta(strCodigo);
                    if (e != null) {
                        System.out.println(e.getCodigo() + ":" + e.getDescrição());
                        String strConf = menu.readInput("Deseja realmente remover a ementa do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerEmenta.removeEmenta(strCodigo);
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
