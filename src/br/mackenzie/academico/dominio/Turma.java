//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class Turma implements java.io.Serializable {

    private String codigo;
    private String periodoDeIngresso;
    private Curso curso;

    public Turma(Curso curso) {
        this.curso = curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPeriodoDeIngresso() {
        return periodoDeIngresso;
    }

    public void setPeriodoDeIngresso(String periodoDeIngresso) {
        this.periodoDeIngresso = periodoDeIngresso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
