//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.controller.ControllerCalendarioLetivo;
import br.mackenzie.academico.utils.Menu;
import java.util.List;

public class CadastroCalendarioLetivo {

    public static String[] menuPrincipal = {
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/",
        "_/_/     Menu Principal",
        "_/_/     (1) Adicionar novo Calendario.",
        "_/_/     (2) Listar Calendario cadastrados.",
        "_/_/     (3) Atualizar Calendario.",
        "_/_/     (4) Remover Calendario do cadastro.",
        "_/_/     (0) Sai do sistema.",
        "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/"
    };

    public static void menu() {
        Menu menu = new Menu();
        boolean runMenuPrincipal = true;
        ControllerCalendarioLetivo controllerCalendarioLetivo = new ControllerCalendarioLetivo();

        while (runMenuPrincipal) {
            menu.mostraMenu(CadastroCalendarioLetivo.menuPrincipal);
            String str = menu.readInput("Sua escolha:");
            switch (str) {

                case "1": {
                    System.out.println("Inclusao de registro");
                    String strEventos = menu.readInput("Entre com os Eventos do Calendário:");
                    String strFeriados = menu.readInput("Entre com os Feriados do Calendário:");
                    controllerCalendarioLetivo.criaCalendario(strEventos, strFeriados);
                    break;
                }
                case "2":
                    System.out.println("Lista Calendarios");
                    List<CalendarioLetivo> calendarios = controllerCalendarioLetivo.listaCalendariosLetivos();
                    for (CalendarioLetivo cl : calendarios) {
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
