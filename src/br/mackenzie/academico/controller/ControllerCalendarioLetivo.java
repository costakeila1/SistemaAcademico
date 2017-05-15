//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.excecao.CalendarioNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceCalendarioLetivo;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerCalendarioLetivo {
    
    private InterfaceCalendarioLetivo icalendario;
    
    public ControllerCalendarioLetivo(){
        icalendario = (InterfaceCalendarioLetivo) Modelo.getInstance();
    }

    public void criaCalendario(int ano, int semestre, String strEventos, String strFeriados) {
        CalendarioLetivo novoCalendarioLetivo = new CalendarioLetivo(ano, semestre, strEventos,strFeriados);
        icalendario.criaCalendarioLetivo(novoCalendarioLetivo);
    }

    public List<CalendarioLetivo> listaCalendariosLetivos() {
        return icalendario.listaCalendariosLetivos();
    }


    public CalendarioLetivo recuperaCalendario(String ano, String semestre) throws CalendarioNaoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeCalendarioLetivo(CalendarioLetivo cl) {
        icalendario.removeCalendarioLetivo(cl);
    }

    public void atualizaCalendarioLetivo(CalendarioLetivo cl) {
        icalendario.atualizaCalendarioLetivo(cl);
    }

    


    
}
