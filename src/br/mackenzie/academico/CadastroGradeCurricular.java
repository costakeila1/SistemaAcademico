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

import br.mackenzie.academico.controller.ControllerGradeCurricular;
import br.mackenzie.academico.dominio.GradeCurricular;
import br.mackenzie.academico.modelo.Modelo;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

<<<<<<< HEAD
public class CadastroGradeCurricular {

=======
/**
 *
 * @author gabriel domenicali
 */
public class CadastroGradeCurricular {
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar nova Grade.",
        "_/_/     (2) Listar Grades cadastradas.",
        "_/_/     (3) Atualizar Grade.",
        "_/_/     (4) Remover Grade do cadastro.",
        "_/_/     (5) Salva o modelo.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

<<<<<<< HEAD
    public static void menu() {
=======

    public static void menu(){
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerGradeCurricular controllerGradeCurricular = new ControllerGradeCurricular();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroGradeCurricular.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
<<<<<<< HEAD
            switch (str) {
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strProjetoPedagogico = menu.readInput("Entre com o projeto pedagogico:");
                    String strInformacoes = menu.readInput("Entre com as informações:");
                    controllerGradeCurricular.criaGradeCurricular(strProjetoPedagogico, strInformacoes);
                    break;
                }
                case "2":
                    System.out.println("Lista Cursos");
                    List<GradeCurricular> grades = controllerGradeCurricular.listaGradesCurriculares();
                    for (GradeCurricular g : grades) {
                        System.out.println(g.getProjetoPedagogico() + ":" + g.getInformacoes());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String strProjetoPedagogico = menu.readInput("Entre com as  da grade:");
                    GradeCurricular g = controllerGradeCurricular.recuperaGradeCurricular(strProjetoPedagogico);
                    if (g != null) {
                        String strInformacoes = menu.readInput("Entre com as informacoes" + g.getInformacoes());
                        g.setInformacoes(strInformacoes);
                        controllerGradeCurricular.atualizaGradeCurricular(g);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strProjetoPedagogico = menu.readInput("Entre com o projeto pedagogico:");
                    GradeCurricular g = controllerGradeCurricular.recuperaGradeCurricular(strProjetoPedagogico);
                    if (g != null) {
                        System.out.println(g.getInformacoes());
                        String strConf = menu.readInput("Deseja realmente remover o curso do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerGradeCurricular.removeGradeCurricular(g);
                        }

                    }
                    break;
                }
                case "5":
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
=======
            if (str.equals("1")) {
                System.out.println("Inclusao de registro");
                String strProjetoPedagogico = menu.readInput("Entre com o projeto pedagogico:");
                String strInformacoes = menu.readInput("Entre com as informações:");
                controllerGradeCurricular.criaGradeCurricular(strProjetoPedagogico, strInformacoes);
            } else if (str.equals("2")) {
                System.out.println("Lista Cursos");
                List<GradeCurricular> grades = controllerGradeCurricular.listaGradesCurriculares();
                for (GradeCurricular g : grades) {
                    System.out.println(g.getProjetoPedagogico() + ":" + g.getInformacoes());
                }
            } else if (str.equals("3")) {
                System.out.println("Atualiza");
                String strProjetoPedagogico = menu.readInput("Entre com as  da grade:");
                GradeCurricular g = controllerGradeCurricular.recuperaGradeCurricular(strProjetoPedagogico);
                if (g != null) {
                    String strInformacoes = menu.readInput("Entre com as informacoes" + g.getInformacoes());
                    g.setInformacoes(strInformacoes);
                    controllerGradeCurricular.atualizaGradeCurricular(g);
                }

            } else if (str.equals("4")) {
                System.out.println("Remove");
                String strProjetoPedagogico = menu.readInput("Entre com o projeto pedagogico:");
                GradeCurricular g = controllerGradeCurricular.recuperaGradeCurricular(strProjetoPedagogico);
                if (g != null) {
                    System.out.println(g.getInformacoes());
                    String strConf = menu.readInput("Deseja realmente remover o curso do cadastro (S/N):");
                    if (strConf.equals("S")) {
                        controllerGradeCurricular.removeGradeCurricular(g);
                    }

                }
            } else if (str.equals("5")) {
                Modelo.getInstance().persisteDados();
                System.out.println("Modelo salvo.");
            } else if (str.equals("0")) {
                runMenuPrincipal = false;
            } else {
                System.out.println("Entrada Invalida");
            }
        }

    }    
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
}
