//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class ComponenteCurricular implements java.io.Serializable {

    private String codigo;
    private String nome;
    private Ementa ementa;

    public ComponenteCurricular(Ementa ementa) {
        this.ementa = ementa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmenta(Ementa ementa){
        this.ementa = ementa;
    }

}
