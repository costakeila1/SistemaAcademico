//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class Matricula implements java.io.Serializable {

    private float mediaFinal;
    private String status;
    public Aluno aluno;
    public Oferecimento oferecimento;

    public Matricula(Aluno aluno, Oferecimento oferecimento) {
        this.aluno = aluno;
        this.oferecimento = oferecimento;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public String getStatus() {
        return status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Oferecimento getOferecimento() {
        return oferecimento;
    }

    public void setMediaFinal(float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
