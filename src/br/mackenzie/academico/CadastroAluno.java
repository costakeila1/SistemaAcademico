//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerAluno;
import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroAluno {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo aluno.",
        "_/_/     (2) Listar alunos cadastrados.",
        "_/_/     (3) Atualizar aluno.",
        "_/_/     (4) Remover aluno do cadastro.",
        "_/_/     (0) Sai do aluno.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerAluno controllerAluno = new ControllerAluno();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroAluno.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String nome = menu.readInput("Entre com o nome do aluno:");
                    String tia = menu.readInput("Entre com o TIA do aluno:");
                    String codigo_turma = menu.readInput("Entre com a turma do aluno (código):");
                    controllerAluno.criaAluno(nome, tia, codigo_turma);
                    break;
                }
                case "2": {
                    System.out.println("Lista alunos");
                    List<Aluno> alunos = controllerAluno.listaAlunos();
                    if (alunos != null) {
                        for (Aluno a : alunos) {
                            System.out.println("[" + a.getTIA() + "] " + a.getNome());
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("Atualiza");
                    String tia = menu.readInput("Entre com o TIA do aluno:");
                    Aluno a = controllerAluno.recuperaAluno(tia);
                    if (a != null) {
                        String strnome = menu.readInput("Entre com o novo nome [" + a.getNome() + "]:");
                        a.setNome(strnome);
                        String strturma = menu.readInput("Entre com o código da nova turma [" + a.getTurma().getCodigo() + "] ");
                        Turma turma = controllerAluno.recuperaTurma(strturma);
                        a.setTurma(turma);
                        controllerAluno.atualizaAluno(a);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String tia = menu.readInput("Entre com o tia do aluno:");
                    Aluno a = controllerAluno.recuperaAluno(tia);
                    if (a != null) {
                        System.out.println("[" + a.getTIA() + "] " + a.getNome());
                        String strConf = menu.readInput("Deseja realmente remover o curso do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerAluno.removeAluno(a);
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
