//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class PlanoEnsino extends Ementa implements java.io.Serializable{
    
    private String conceitos;
    private String conteudoProgramatico;
    private String criteriosAvaliacao;
    private String habilidades;
    private String metodologia;
    private String valores;
    
    public PlanoEnsino(String bibliografiaBasica, 
                       String bibliografiaComplementar, 
                       String descriçãoEmenta, 
                       String conceitos, 
                       String conteudoProgramatico, 
                       String criteriosAvaliacao, 
                       String habilidades, 
                       String metodologia, 
                       String valores) {
        super(bibliografiaBasica, bibliografiaComplementar, descriçãoEmenta);
        this.conceitos = conceitos;
        this.conteudoProgramatico = conteudoProgramatico;
        this.criteriosAvaliacao = criteriosAvaliacao;
        this.habilidades = habilidades;
        this.metodologia = metodologia;
        this.valores = valores;
        }
    
    public String getConceitos() {
        return conceitos;
    }

    public void setConceitos(String conceitos) {
        this.conceitos = conceitos;
    }

    public String getConteudoProgramatico() {
        return conteudoProgramatico;
    }

    public void setConteudoProgramatico(String conteudoProgramatico) {
        this.conteudoProgramatico = conteudoProgramatico;
    }

    public String getCriteriosAvaliacao() {
        return criteriosAvaliacao;
    }

    public void setCriteriosAvaliacao(String criteriosAvaliacao) {
        this.criteriosAvaliacao = criteriosAvaliacao;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }
    
}
