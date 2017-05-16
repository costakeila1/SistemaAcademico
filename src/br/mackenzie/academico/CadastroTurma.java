//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerTurma;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.utils.Menu;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroTurma {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar nova Turma.",
        "_/_/     (2) Listar Turmas cadastradas.",
        "_/_/     (3) Atualizar Turma.",
        "_/_/     (4) Remover turma do cadastro.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerTurma controllerTurma = new ControllerTurma();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroTurma.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strNome = menu.readInput("Entre com o nome do curso:");
                    String strCodigo = menu.readInput("Entre com o codigo da turma:");
                    String strPeriodo = menu.readInput("Entre com o periodo de ingresso:");
                    try {
                        controllerTurma.criaTurma(strNome, strCodigo, strPeriodo);
                    } catch (CursoNaoEncontradoException ex) {
                        Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "2":
                    System.out.println("Lista Turma");
                    List<Turma> turmas = controllerTurma.listaTurmas();
                    for (Turma t : turmas) {
                        System.out.println(t.getCodigo() + ":" + t.getPeriodoDeIngresso() + ":" + t.getCurso().getNome());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String strCodigo = menu.readInput("Entre com o codigo da Turma:");
                    Turma t = controllerTurma.recuperaTurma(strCodigo);
                    if (t != null) {
                        String strPeriodo = menu.readInput("Entre com o novo periodo [" + t.getPeriodoDeIngresso() + "]:");
                        t.setPeriodoDeIngresso(strPeriodo);
                        controllerTurma.atualizaTurma(t);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strCodigo = menu.readInput("Entre com o codigo da turma:");
                    Turma t = controllerTurma.recuperaTurma(strCodigo);
                    if (t != null) {
                        System.out.println(t.getCodigo() + ":" + t.getCurso().getNome());
                        String strConf = menu.readInput("Deseja realmente remover a turma do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerTurma.removeTurma(t);
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
