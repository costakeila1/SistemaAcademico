//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class Professor implements java.io.Serializable{
    private String DRT;
    private String nome;
    private Oferecimento oferecimento;
    
    public Professor(Oferecimento oferecimento){
        this.oferecimento = oferecimento;
    }

    public String getDRT() {
        return DRT;
    }

    public void setDRT(String DRT) {
        this.DRT = DRT;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Oferecimento getOferecimento() {
        return oferecimento;
    }

    public void setOferecimento(Oferecimento oferecimento) {
        this.oferecimento = oferecimento;
    }   
}