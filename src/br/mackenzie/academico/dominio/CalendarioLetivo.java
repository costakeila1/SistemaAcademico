/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.dominio;

import java.io.Serializable;

/**
 *
 * @author gabriel domenicali
 */
public class CalendarioLetivo implements Serializable{
    private String eventos;
    private String feriados;
    
    public CalendarioLetivo(String eventos, String feriados){
        this.eventos=eventos;
        this.feriados=feriados;
    }

    public String getEventos() {
        return eventos;
    }

    public void setEventos(String eventos) {
        this.eventos = eventos;
    }

    public String getFeriados() {
        return feriados;
    }

    public void setFeriados(String feriados) {
        this.feriados = feriados;
    }
        
}