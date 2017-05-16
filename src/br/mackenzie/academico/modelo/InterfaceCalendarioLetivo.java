//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.excecao.CalendarioNaoEncontradoException;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import java.util.List;

public interface InterfaceCalendarioLetivo {

    public List<CalendarioLetivo> listaCalendariosLetivos();

    public void criaCalendarioLetivo(CalendarioLetivo novoCalendarioLetivo);

    public CalendarioLetivo recuperaCalendarioLetivo(String eventos) throws CalendarioNaoEncontradoException;

    public void atualizaCalendarioLetivo(CalendarioLetivo cl);

    public void removeCalendarioLetivo(CalendarioLetivo cl);
}
