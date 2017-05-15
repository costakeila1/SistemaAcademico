/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.controller;

import br.mackenzie.academico.CadastroCalendarioLetivo;
import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.modelo.InterfaceCalendarioLetivo;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

/**
 *
 * @author gabriel domenicali
 */
public class ControllerCalendarioLetivo {
    
    private InterfaceCalendarioLetivo icalendario;
    
    public ControllerCalendarioLetivo(){
        icalendario = (InterfaceCalendarioLetivo) Modelo.getInstance();
    }

    public void criaCalendario(String strEventos, String strFeriados) {
        CalendarioLetivo novoCalendarioLetivo = new CalendarioLetivo(strEventos,strFeriados);
        icalendario.criaCalendarioLetivo(novoCalendarioLetivo);
    }

    public List<CalendarioLetivo> listaCalendariosLetivos() {
        return icalendario.listaCalendariosLetivos();
    }


    public CalendarioLetivo recuperaCalendarioLetivo(String eventos) {
        return icalendario.recuperaCalendarioLetivo(eventos);
    }

    public void removeCalendarioLetivo(CalendarioLetivo cl) {
        icalendario.removeCalendarioLetivo(cl);
    }

    public void atualizaCalendarioLetivo(CalendarioLetivo cl) {
        icalendario.atualizaCalendarioLetivo(cl);
    }


    
}
