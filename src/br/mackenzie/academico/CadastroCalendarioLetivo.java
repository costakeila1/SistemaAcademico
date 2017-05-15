<<<<<<< HEAD
//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico;
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.controller.ControllerCalendarioLetivo;
import br.mackenzie.academico.modelo.Modelo;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

<<<<<<< HEAD
public class CadastroCalendarioLetivo {

    public static String[] menuPrincipal = {
=======
/**
 *
 * @author gabriel domenicali
 */
public class CadastroCalendarioLetivo {
        public static String[] menuPrincipal = {
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Calendario.",
        "_/_/     (2) Listar Calendario cadastrados.",
        "_/_/     (3) Atualizar Calendario.",
        "_/_/     (4) Remover Calendario do cadastro.",
        "_/_/     (5) Salva o modelo.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerCalendarioLetivo controllerCalendarioLetivo = new ControllerCalendarioLetivo();
<<<<<<< HEAD

=======
        
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroCalendarioLetivo.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {
<<<<<<< HEAD
                case "1": {
                    System.out.println("Inclusao de registro");
                    String strEventos = menu.readInput("Entre com os Eventos do Calendário:");
                    String strFeriados = menu.readInput("Entre com os Feriados do Calendário:");
                    controllerCalendarioLetivo.criaCalendario(strEventos, strFeriados);
                    break;
                }
=======
                case "1":
                    {
                        System.out.println("Inclusao de registro");
                        String strEventos = menu.readInput("Entre com os Eventos do Calendário:");
                        String strFeriados = menu.readInput("Entre com os Feriados do Calendário:");
                        controllerCalendarioLetivo.criaCalendario(strEventos, strFeriados);
                        break;
                    }
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
                case "2":
                    System.out.println("Lista Calendarios");
                    List<CalendarioLetivo> calendarios = controllerCalendarioLetivo.listaCalendariosLetivos();
                    for (CalendarioLetivo cl : calendarios) {
<<<<<<< HEAD
                        System.out.println(cl.getEventos() + ":" + cl.getFeriados());
                    }
                    break;
                case "3": {
                    System.out.println("Atualiza");
                    String strEventos = menu.readInput("Entre com o Evento do Calendário:");
                    CalendarioLetivo cl = null;
                    if (cl != null) {
                        String streventos = menu.readInput("Entre com os novos evento [" + cl.getEventos() + "]:");
                        String strferiados = menu.readInput("Entre com os novos feriado [" + cl.getFeriados() + "]:");
                        cl.setEventos(streventos);
                        cl.setFeriados(strferiados);
                        controllerCalendarioLetivo.atualizaCalendarioLetivo(cl);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Remove");
                    String strEventos = menu.readInput("Entre com os Eventos do Calendário:");
                    CalendarioLetivo cl = controllerCalendarioLetivo.recuperaCalendarioLetivo(strEventos);
                    if (cl != null) {
                        System.out.println(cl.getEventos());
                        String strConf = menu.readInput("Deseja realmente remover a faculdade do cadastro (S/N):");
                        if (strConf.equals("S")) {
                            controllerCalendarioLetivo.removeCalendarioLetivo(cl);
                        }

                    }
                    break;
                }
=======
                        System.out.println(cl.getEventos()+ ":" + cl.getFeriados());
                    }   break;
                case "3":
                    {
                        System.out.println("Atualiza");
                        String strEventos = menu.readInput("Entre com o Evento do Calendário:");
                        CalendarioLetivo cl = null;
                        if (cl != null) {
                            String streventos = menu.readInput("Entre com os novos evento [" + cl.getEventos() + "]:");
                            String strferiados = menu.readInput("Entre com os novos feriado [" + cl.getFeriados() + "]:");
                            cl.setEventos(streventos);
                            cl.setFeriados(strferiados);
                            controllerCalendarioLetivo.atualizaCalendarioLetivo(cl);
                        }       break;
                    }
                case "4":
                    {
                        System.out.println("Remove");
                        String strEventos = menu.readInput("Entre com os Eventos do Calendário:");
                        CalendarioLetivo cl = controllerCalendarioLetivo.recuperaCalendarioLetivo(strEventos);
                        if (cl != null) {
                            System.out.println(cl.getEventos());
                            String strConf = menu.readInput("Deseja realmente remover a faculdade do cadastro (S/N):");
                            if (strConf.equals("S")) {
                                controllerCalendarioLetivo.removeCalendarioLetivo(cl);
                            }
                            
                        }       break;
                    }
>>>>>>> 0f0e1d0453575a29ec3168df2f61ac8400cbd7ea
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
}
