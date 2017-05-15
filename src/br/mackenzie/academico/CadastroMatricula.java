//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerMatricula;
import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.excecao.AlunoNaoEncontradoException;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroMatricula {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar nova matricula.",
        "_/_/     (2) Listar matriculas cadastradas.",
        "_/_/     (3) Atualizar matricula.",
        "_/_/     (4) Remover matricula do cadastro.",
        "_/_/     (0) Sai da matricula.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerMatricula controllerMatricula = new ControllerMatricula();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroMatricula.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String tia = menu.readInput("Entre com o TIA do aluno:");
                    String codigo_turma = menu.readInput("Entre com o código da turma:");
                    String codigo_componente = menu.readInput("Entre com o código do componente curricular: ");
                    try {
                        controllerMatricula.criaMatricula(tia, codigo_turma, codigo_componente);
                    } catch (AlunoNaoEncontradoException ex) {
                        System.out.println("Aluno não foi encontrado com o TIA:" + tia);
                    }
                    break;
                }
                case "2": {
                    System.out.println("Lista matriculas");
                    List<Matricula> matriculas = controllerMatricula.listaMatriculas();
                    for (Matricula m : matriculas) {
                        System.out.println(m.getOferecimento().getTurma().getCodigo() + " : " + m.getOferecimento().getComponenteCurricular().getNome());
                    }
                    break;
                }
                case "3": {
                    System.out.println("Atualiza");
                    String tia = menu.readInput("Entre com o TIA do aluno:");
                    String codigo_turma = menu.readInput("Entre com o código da turma:");
                    String codigo_componente = menu.readInput("Entre com o código do componente curricular: ");
                    Matricula matricula = null;
                    try {
                        matricula = controllerMatricula.recuperaMatricula(tia, codigo_turma, codigo_componente);
                    } catch (AlunoNaoEncontradoException ex) {
                        System.out.println("Aluno não foi encontrado com o TIA:" + tia);
                    }
                    if (matricula != null) {
                        String status = menu.readInput("Entre com o novo status: ");
                        Float media_final = Float.parseFloat(menu.readInput("Entre com a nova média final: "));
                        matricula.setStatus(status);
                        matricula.setMediaFinal(media_final);
                        controllerMatricula.atualizaMatricula(matricula);
                    }
                    break;
                }

                case "4": {
                    System.out.println("Remove");
                    String tia = menu.readInput("Entre com o TIA do aluno:");
                    String codigo_turma = menu.readInput("Entre com o código da turma:");
                    String codigo_componente = menu.readInput("Entre com o código do componente curricular: ");
                    Matricula m = null;
                    try {
                        m = controllerMatricula.recuperaMatricula(tia, codigo_turma, codigo_componente);
                    } catch (AlunoNaoEncontradoException ex) {
                        System.out.println("Aluno não foi encontrado com o TIA:" + tia);
                    }
                    if (m != null) {
                        System.out.println(m.getOferecimento().getTurma().getCodigo() + " : " + m.getOferecimento().getComponenteCurricular().getNome());
                        String strConf = menu.readInput("Deseja realmente remover a matricula do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerMatricula.removeMatricula(m);
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
