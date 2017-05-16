//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerConsulta;
import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.modelo.Modelo;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class SistemaAcademico {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/ Menu Principal",
        "_/_/ (1)  Manter Faculdade.",
        "_/_/ (2)  Manter Curso.",
        "_/_/ (3)  Manter Turma.",
        "_/_/ (4)  Manter Componente Curricular.",
        "_/_/ (5)  Manter Oferecimento.",
        "_/_/ (5a) Consultar Oferecimentos por Turma.",
        "_/_/ (6)  Manter matricula.",
        "_/_/ (6a) Consultar matriculas por aluno.",
        "_/_/ (7)  Manter aluno.",
        "_/_/ (9)  Salva o modelo.",
        "_/_/ (0)  Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void main(String[] args) {
        ControllerConsulta controllerConsulta = new ControllerConsulta();
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        Modelo.getInstance().carregaDados();


        while (runMenuPrincipal) {
            menu.mostraMenu(SistemaAcademico.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
                case "1":
                    System.out.println("Manter Faculdade");
                    CadastroFaculdade.menu();
                    break;
                case "2":
                    System.out.println("Manter Curso");
                    CadastroCurso.menu();
                    break;
                case "3":
                    System.out.println("Manter Turma");
                    CadastroTurma.menu();
                    break;
                case "4":
                    System.out.println("Manter Componente Curricular");
                    CadastroComponenteCurricular.menu();
                    break;
                case "5":
                    System.out.println("Manter Oferecimento");
                    CadastroOferecimento.menu();
                    break;
                case "5a":
                    System.out.println("Consulta oferecimentos de uma turma");
                    String codigo_turma = menu.readInput("Entre com o código da turma:");
                    List<Oferecimento> oferecimentos = controllerConsulta.buscaOferecimentosTurma(codigo_turma);
                    System.out.println("Turma: " + codigo_turma);
                    for (Oferecimento o : oferecimentos) {
                        System.out.println("Componente curricular [" + o.getComponenteCurricular().getCodigo() + "]" + ":" + o.getComponenteCurricular().getNome());
                    }
                    break;
                case "6":
                    System.out.println("Manter Matricula");
                    CadastroMatricula.menu();
                    break;
                case "6a":
                    System.out.println("Matriculas por aluno");
                    String tia = menu.readInput("Entre com o tia do aluno: ");
                    List<Matricula> matriculas = controllerConsulta.buscaMatriculasAluno(tia);
                    for (Matricula m : matriculas) {
                        System.out.println(m.getOferecimento().getTurma().getCodigo() + " : " + m.getOferecimento().getComponenteCurricular().getNome());
                    }
                    break;
                case "7":
                    System.out.println("Manter Aluno");
                    CadastroAluno.menu();
                    break;
                case "9":
                    Modelo.getInstance().persisteDados();
                    System.out.println("Modelo salvo.");
                    break;
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
