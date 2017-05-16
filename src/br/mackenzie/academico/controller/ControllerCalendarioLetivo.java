//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.excecao.CalendarioNaoEncontradoException;
import br.mackenzie.academico.modelo.InterfaceCalendarioLetivo;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerCalendarioLetivo {
    
    private InterfaceCalendarioLetivo iCalendario;
    
    public ControllerCalendarioLetivo(){
        iCalendario = (InterfaceCalendarioLetivo) Modelo.getInstance();
    }

    public void criaCalendario(int ano, int semestre, String strEventos, String strFeriados) {
        CalendarioLetivo novoCalendarioLetivo = new CalendarioLetivo(ano, semestre, strEventos,strFeriados);
        iCalendario.criaCalendarioLetivo(novoCalendarioLetivo);
    }

    public List<CalendarioLetivo> listaCalendariosLetivos() {
        return iCalendario.listaCalendariosLetivos();
    }


    public CalendarioLetivo recuperaCalendarioLetivo(String eventos) throws CalendarioNaoEncontradoException {
        return iCalendario.recuperaCalendarioLetivo(eventos);
    }

    public void removeCalendarioLetivo(CalendarioLetivo cl) {
        iCalendario.removeCalendarioLetivo(cl);
    }

    public void atualizaCalendarioLetivo(CalendarioLetivo cl) {
        iCalendario.atualizaCalendarioLetivo(cl);
    }

    


    
}
