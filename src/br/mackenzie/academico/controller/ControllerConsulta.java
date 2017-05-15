//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.modelo.InterfaceConsulta;
import br.mackenzie.academico.modelo.Modelo;
import java.util.List;

public class ControllerConsulta {
    
    private InterfaceConsulta iconsulta;
    
    public ControllerConsulta(){
        iconsulta = (InterfaceConsulta) Modelo.getInstance();
    }

    public List<Oferecimento> buscaOferecimentosTurma(String codigo_turma) {
        List<Oferecimento> oferecimentos = iconsulta.buscaOferecimentosTurma(codigo_turma);
        return oferecimentos;
    }

    public List<Matricula> buscaMatriculasAluno(String tia) {
        List<Matricula> matriculas = iconsulta.buscaMatriculasAluno(tia);
        return matriculas;
    }

}
