//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

import java.io.Serializable;

public class Ementa implements Serializable {

    private String codigo;
    private String descriçãoEmenta;
    private String bibliografiaBasica;
    private String bibliografiaComplementar;
    

    public Ementa(String bibliografiaBasica, String bibliografiaComplementar, String descriçãoEmenta) {
        this.bibliografiaBasica = bibliografiaBasica;
        this.bibliografiaComplementar = bibliografiaComplementar;
        this.descriçãoEmenta = descriçãoEmenta;
    }

    public String getBibliografiaBasica() {
        return bibliografiaBasica;
    }

    public String getBibliografiaComplementar() {
        return bibliografiaComplementar;
    }

    public String getDescriçãoEmenta() {
        return descriçãoEmenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
