<<<<<<< HEAD
//[315.31.89-1] Keila Lopes Costa 
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
package br.mackenzie.academico;

import br.mackenzie.academico.controller.ControllerProjetoPedagogico;
import br.mackenzie.academico.utils.Menu;

<<<<<<< HEAD
public class CadastroProjetoPedagogico {

    public static String[] menuPrincipal = {
=======
/**
 *
 * @author gabriel domenicali
 */
public class CadastroProjetoPedagogico {
       public static String[] menuPrincipal = {
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Projeto Pedagogio.",
        "_/_/     (2) Listar Projetos Cadastrados.",
        "_/_/     (3) Atualizar Projeto.",
        "_/_/     (4) Remover projeto do cadastro.",
        "_/_/     (5) Salva o modelo.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };
<<<<<<< HEAD

=======
    
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerProjetoPedagogico controllerProjetoPedagogico = new ControllerProjetoPedagogico();
<<<<<<< HEAD

=======
        
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroProjetoPedagogico.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            if (str.equals("1")) {
                System.out.println("Inclusao de registro");
                String strNome = menu.readInput("Entre com o nome do curso:");
                String strCodigo = menu.readInput("Entre com o codigo da turma:");
                String strPeriodo = menu.readInput("Entre com o periodo de ingresso:");
<<<<<<< HEAD
                controllerProjetoPedagogico.criaProjetoPedagogico(strNome, strCodigo, strPeriodo);
            } else if (str.equals("2")) {
                System.out.println("Lista Turma");
                List<Turma> turmas = controllerTurma.listaTurmas();
                for (Turma t : turmas) {
                    System.out.println(t.getCodigo() + ":" + t.getPeriodoDeIngresso() + ":" + t.getCurso().getNome());
=======
                controllerTurma.criaTurma(strNome, strCodigo, strPeriodo);
            } else if (str.equals("2")) {
                System.out.println("Lista Turma");
                List<Turma> turmas = controllerTurma.listaTurmas();
                for(Turma t:turmas){
                    System.out.println(t.getCodigo() + ":" + t.getPeriodoDeIngresso()+ ":" +t.getCurso().getNome());
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
                }
            } else if (str.equals("3")) {
                System.out.println("Atualiza");
                String strCodigo = menu.readInput("Entre com o codigo da Turma:");
                Turma t = controllerTurma.recuperaTurma(strCodigo);
<<<<<<< HEAD
                if (t != null) {
                    String strPeriodo = menu.readInput("Entre com o novo periodo [" + t.getPeriodoDeIngresso() + "]:");
                    t.setPeriodoDeIngresso(strPeriodo);
                    controllerTurma.atualizaTurma(t);
                }

=======
                if (t != null){
                    String strPeriodo = menu.readInput("Entre com o novo periodo [" + t.getPeriodoDeIngresso() + "]:");
                    t.setPeriodoDeIngresso(strPeriodo);
                    controllerTurma.atualizaTurma(t);
                }    
                    
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
            } else if (str.equals("4")) {
                System.out.println("Remove");
                String strCodigo = menu.readInput("Entre com o codigo da turma:");
                Turma t = controllerTurma.recuperaTurma(strCodigo);
<<<<<<< HEAD
                if (t != null) {
                    System.out.println(t.getCodigo() + ":" + t.getCurso().getNome());
                    String strConf = menu.readInput("Deseja realmente remover a turma do cadastro (S/N):");
                    if (strConf.equals("S")) {
                        controllerTurma.removeTurma(t);
                    }

                }
            } else if (str.equals("5")) {
                Modelo.getInstance().persisteDados();
                System.out.println("Modelo salvo.");
=======
                if (t!=null){
                    System.out.println(t.getCodigo() + ":" + t.getCurso().getNome());
                    String strConf = menu.readInput("Deseja realmente remover a turma do cadastro (S/N):");
                    if (strConf.equals("S")){
                        controllerTurma.removeTurma(t);
                    }
                    
                }
            }else if (str.equals("5")) {
                Modelo.getInstance().persisteDados();
                System.out.println("Modelo salvo.");    
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
            } else if (str.equals("0")) {
                runMenuPrincipal = false;
            } else {
                System.out.println("Entrada Invalida");
            }
        }
<<<<<<< HEAD
    }
=======
    }    
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
}
