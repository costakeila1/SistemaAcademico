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
public class PlanoAula extends PlanoEnsino implements Serializable {
    private String planejamentoAula;
    private CalendarioLetivo calendarioLetivo;
    private Oferecimento oferecimento;
    
    public PlanoAula(CalendarioLetivo calendarioLetivo, Oferecimento oferecimento, String planejamentoAula, String bibliografiaBasica, String bibliografiaComplementar, String ementa, String conceitos, String conteudoProgramatico, String criteriosAvaliacao, String habilidades, String metodologia, String valores) {
        super(bibliografiaBasica, bibliografiaComplementar, ementa, conceitos, conteudoProgramatico, criteriosAvaliacao, habilidades, metodologia, valores);
        this.planejamentoAula = planejamentoAula;
        this.calendarioLetivo = calendarioLetivo;
        this.oferecimento = oferecimento;
    }

    public String getPlanejamentoAula() {
        return planejamentoAula;
    }

    public void setPlanejamentoAula(String planejamentoAula) {
        this.planejamentoAula = planejamentoAula;
    }

    public CalendarioLetivo getCalendarioLetivo() {
        return calendarioLetivo;
    }

    public void setCalendarioLetivo(CalendarioLetivo calendarioLetivo) {
        this.calendarioLetivo = calendarioLetivo;
    }

    public Oferecimento getOferecimento() {
        return oferecimento;
    }

    public void setOferecimento(Oferecimento oferecimento) {
        this.oferecimento = oferecimento;
    }    
}