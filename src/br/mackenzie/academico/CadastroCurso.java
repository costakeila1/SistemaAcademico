//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerCurso;
import br.mackenzie.academico.dominio.Curso;
<<<<<<< HEAD
=======
import br.mackenzie.academico.modelo.Modelo;
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroCurso {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Curso.",
        "_/_/     (2) Listar Cursos cadastrados.",
        "_/_/     (3) Atualizar Curso.",
        "_/_/     (4) Remover curso do cadastro.",
        "_/_/     (0) Sai do curso.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerCurso controllerCurso = new ControllerCurso();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroCurso.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1":
                    {
                        System.out.println("Inclusao de registro");
                        String strCnpj = menu.readInput("Entre com o CNPJ da Faculdade:");
                        String strNome = menu.readInput("Entre com o nome do curso:");
                        controllerCurso.criaCurso(strCnpj, strNome);
                        break;
                    }
                case "2":
                    System.out.println("Lista Cursos");
                    List<Curso> cursos = controllerCurso.listaCursos();
                    for (Curso c : cursos) {
                        System.out.println(c.getNome() + ":" + c.getFaculdade().getCNPJ() + ":" + c.getFaculdade().getNome());
                    }   break;
                case "3":
                    {
                        System.out.println("Atualiza");
                        String strNome = menu.readInput("Entre com o nome do curso:");
                        Curso c = controllerCurso.recuperaCurso(strNome);
                        if (c != null) {
                            String strnome = menu.readInput("Entre com o novo nome [" + c.getNome() + "]:");
                            c.setNome(strnome);
                            controllerCurso.atualizaCurso(c);
                        }       break;
                    }
                case "4":
                    {
                        System.out.println("Remove");
                        String strNome = menu.readInput("Entre com o nome do curso:");
                        Curso c = controllerCurso.recuperaCurso(strNome);
                        if (c != null) {
                            System.out.println(c.getNome() + ":" + c.getFaculdade().getNome());
                            String strConf = menu.readInput("Deseja realmente remover o curso do cadastro (S/N):");
                            if (strConf.equals("S")) {
                                controllerCurso.removeCurso(c);
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
