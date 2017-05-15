//[315.31.89-1] Keila Lopes Costa
package br.mackenzie.academico.dominio;

public class SemestreLetivo implements java.io.Serializable {

    private int ano;
    private int semestre;

    public SemestreLetivo(int ano, int semestre) {
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
