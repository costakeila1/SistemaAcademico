/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.dominio.PlanoEnsino;
import java.util.List;

/**
 *
 * @author 31546927
 */
public interface InterfacePlanoEnsino {
    public List<PlanoEnsino> listaPlanos();
    public PlanoEnsino recuperaPlanoEnsino(String Ementa);
    public void atualizaPlanoEnsino(PlanoEnsino planoEnsino);
    public void removePlanoEnsino(PlanoEnsino planoEnsino);
    public void criaPlanoEnsino(PlanoEnsino novoPlanoEnsino);
}
