//[315.31.89-1] Keila Lopes Costa
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerSemestreLetivo;
import br.mackenzie.academico.dominio.SemestreLetivo;
import br.mackenzie.academico.excecao.SemestreLetivoNaoEncontradoException;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroSemestreLetivo {

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
        ControllerSemestreLetivo controllerSemestreLetivo = new ControllerSemestreLetivo();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroAluno.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    int ano = Integer.parseInt(menu.readInput("Entre com o ano:"));
                    int semestre = Integer.parseInt(menu.readInput("Entre com o semestre:"));
                    controllerSemestreLetivo.criaSemestreLetivo(ano, semestre);
                    break;
                }
                case "2": {
                    System.out.println("Lista Semestres Letivos");
                    List<SemestreLetivo> semestres = controllerSemestreLetivo.listaSemestresLetivos();
                    if (semestres != null) {
                        for (SemestreLetivo s : semestres) {
                            System.out.println(s.getAno() + "/" + s.getSemestre());
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("Atualiza");
                    int ano = Integer.parseInt(menu.readInput("Entre com o ano:"));
                    int semestre = Integer.parseInt(menu.readInput("Entre com o semestre:"));
                    SemestreLetivo s = null;
                    try {
                        s = controllerSemestreLetivo.recuperaSemestreLetivo(ano, semestre);
                    } catch (SemestreLetivoNaoEncontradoException ex) {
                        System.out.println("Semestre não foi encontrado:" + ano + "/" + semestre);
                    }
                    if (s != null) {
                        ano = Integer.parseInt(menu.readInput("Entre com o ano:"));
                        semestre = Integer.parseInt(menu.readInput("Entre com o semestre:"));
                        controllerSemestreLetivo.atualizaSemestreLetivo(ano, semestre);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    int ano = Integer.parseInt(menu.readInput("Entre com o ano:"));
                    int semestre = Integer.parseInt(menu.readInput("Entre com o semestre:"));
                    SemestreLetivo s = null;
                    try {
                        s = controllerSemestreLetivo.recuperaSemestreLetivo(ano, semestre);
                    } catch (SemestreLetivoNaoEncontradoException ex) {
                        System.out.println("Semestre não foi encontrado:" + ano + "/" + semestre);
                    }
                    if (s != null) {
                        System.out.println(s.getAno() + "/" + s.getSemestre());
                        String strConf = menu.readInput("Deseja realmente remover o semestre do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerSemestreLetivo.removeSemestreLetivo(s);
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
