//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class GradeCurricular implements java.io.Serializable {

    private ProjetoPedagogico projetoPedagogico;
    private String informacoes;

    public GradeCurricular(ProjetoPedagogico projetoPedagogico) {
        this.projetoPedagogico = projetoPedagogico;
    }

    public ProjetoPedagogico getProjetoPedagogico() {
        return projetoPedagogico;
    }

    public void setProjetoPedagogico(ProjetoPedagogico projetoPedagogico) {
        this.projetoPedagogico = projetoPedagogico;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}
