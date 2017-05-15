//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.controller;

import br.mackenzie.academico.dominio.PlanoEnsino;
import br.mackenzie.academico.modelo.InterfacePlanoEnsino;
import java.util.List;

public class ControllerPlanoEnsino {
    
    private InterfacePlanoEnsino iPlanoEnsino;

    public void criaPlanoEnsino(String descriçãoEmenta, String bBasica, String bComplementar, String conceitos, String conteudoProgramatico, String criteriosAvaliacao, String habilidades, String metodologia, String valores) {
        PlanoEnsino novoPlanoEnsino = new PlanoEnsino(descriçãoEmenta, bBasica, bComplementar, conceitos, conteudoProgramatico, criteriosAvaliacao, habilidades, metodologia, valores);
        iPlanoEnsino.criaPlanoEnsino(novoPlanoEnsino);
    }

    public List<PlanoEnsino> listaPlanosEnsino() {
        return iPlanoEnsino.listaPlanos();
    }
    
    public PlanoEnsino recuperaPlanoEnsino(String codigoEmenta){
        return iPlanoEnsino.recuperaPlanoEnsino(codigoEmenta);
    }    

    public void atualizaPlanoEnsino(PlanoEnsino pe) {
        iPlanoEnsino.atualizaPlanoEnsino(pe);
    }

    public void removePlanoEnsino(PlanoEnsino pe) {
        iPlanoEnsino.removePlanoEnsino(pe);
    }
}
