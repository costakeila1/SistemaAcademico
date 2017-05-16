//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

import java.io.Serializable;

public class CalendarioLetivo extends SemestreLetivo implements Serializable{
    private String eventos;
    private String feriados;
    
    public CalendarioLetivo(int ano, int semestre, String eventos, String feriados){
        super(ano, semestre);
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