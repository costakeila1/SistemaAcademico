//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

import java.io.Serializable;
import java.util.List;

public class ComponenteCurricular implements Serializable {

    private String codigo;
    private String nome;
    private Ementa ementa;
    private List<SemestreLetivo> semestres;

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
    
    public Ementa getEmenta(){
        return ementa;
    }

    public List<SemestreLetivo> getSemestresLetivos() {
        return semestres;
    }

    public void addSemestresLetivos(SemestreLetivo semestre) {
        semestres.add(semestre);
    }
}
