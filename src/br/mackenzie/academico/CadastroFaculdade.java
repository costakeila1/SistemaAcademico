//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerFaculdade;
import br.mackenzie.academico.dominio.Faculdade;
<<<<<<< HEAD
=======
import br.mackenzie.academico.modelo.Modelo;
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroFaculdade {

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
        ControllerFaculdade controllerFaculdade = new ControllerFaculdade();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroFaculdade.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1":
                    {
                        System.out.println("Inclusao de registro");
                        String strCnpj = menu.readInput("Entre com o CNPJ da Faculdade:");
                        String strEndereco = menu.readInput("Entre com o endereco:");
                        String strTelefone = menu.readInput("Entre com o telefone:");
                        String strNome = menu.readInput("Entre com o nome:");
                        controllerFaculdade.criaFaculdade(strCnpj, strEndereco, strNome, strTelefone);
                        break;
                    }
                case "2":
                    System.out.println("Lista faculdades");
                    List<Faculdade> faculdades = controllerFaculdade.listaFaculdades();
                    for (Faculdade f : faculdades) {
                        System.out.println(f.getNome() + ":" + f.getCNPJ() + ":" + f.getEndereco() + ":" + f.getTelefone());
                    }   break;
                case "3":
                    {
                        System.out.println("Atualiza");
                        String strCnpj = menu.readInput("Entre com o CNPJ da Faculdade:");
                        Faculdade f = controllerFaculdade.recuperaFaculdade(strCnpj);
                        if (f != null) {
                            String strnome = menu.readInput("Entre com o novo nome [" + f.getNome() + "]:");
                            String strtelefone = menu.readInput("Entre com o novo telefone [" + f.getTelefone() + "]:");
                            String strendereco = menu.readInput("Entre com o novo endereco [" + f.getEndereco() + "]:");
                            f.setEndereco(strendereco);
                            f.setTelefone(strtelefone);
                            f.setNome(strnome);
                            controllerFaculdade.atualizaFaculdade(f);
                        }       break;
                    }
                case "4":
                    {
                        System.out.println("Remove");
                        String strCnpj = menu.readInput("Entre com o CNPJ da Faculdade:");
                        Faculdade f = controllerFaculdade.recuperaFaculdade(strCnpj);
                        if (f != null) {
                            System.out.println(f.getNome() + ":" + f.getCNPJ());
                            String strConf = menu.readInput("Deseja realmente remover a faculdade do cadastro (S/N):");
                            if (strConf.equals("S")) {
                                controllerFaculdade.removeFaculdade(f);
                            }
                            
                        }       break;
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
