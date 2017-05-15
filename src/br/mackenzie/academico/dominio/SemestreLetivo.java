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
public class SemestreLetivo extends CalendarioLetivo implements Serializable{
    private int ano;
    private int semestre;
    
    public SemestreLetivo(String eventos, String feriados, int ano, int semestre) {
        super(eventos, feriados);
        this.ano = ano;
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    
}
