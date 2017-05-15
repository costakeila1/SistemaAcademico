/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.GradeCurricular;
import java.util.List;

/**
 *
 * @author gabriel domenicali
 */
public interface InterfaceGradeCurricular {

    public void criaGradeCurricular(GradeCurricular novaGradeCurricular);

    public List<GradeCurricular> listaGradesCurriculares();

    public GradeCurricular recuperaGradeCurricular(String projetoPedagogico);

    public void atualizaGradeCurricular(GradeCurricular gradeCurricular);

    public void removeGradeCurricular(GradeCurricular gradeCurricular);
    
}
