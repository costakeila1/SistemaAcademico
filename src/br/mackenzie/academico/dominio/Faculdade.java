//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.dominio;

public class Faculdade implements java.io.Serializable {

    private String CNPJ;
    private String endereco;
    private String nome;
    private String telefone;

    public Faculdade() {

    }

    public Faculdade(String CNPJ, String endereco, String nome, String telefone) {
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}//end Faculdade
