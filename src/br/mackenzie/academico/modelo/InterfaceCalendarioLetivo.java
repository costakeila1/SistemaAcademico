/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import java.util.List;

/**
 *
 * @author gabriel domenicali
 */
public interface InterfaceCalendarioLetivo {


    public List<CalendarioLetivo> listaCalendariosLetivos();

    public void criaCalendarioLetivo(CalendarioLetivo novoCalendarioLetivo);

    public CalendarioLetivo recuperaCalendarioLetivo(String eventos);

    public void removeCalendarioLetivo(CalendarioLetivo cl);

    public void atualizaCalendarioLetivo(CalendarioLetivo cl);
    
    
}
