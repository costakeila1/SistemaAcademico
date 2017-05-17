//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.CalendarioLetivo;
import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.dominio.Faculdade;
import br.mackenzie.academico.dominio.GradeCurricular;
import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.PlanoAula;
import br.mackenzie.academico.dominio.PlanoEnsino;
import br.mackenzie.academico.dominio.Professor;
import br.mackenzie.academico.dominio.ProjetoPedagogico;
import br.mackenzie.academico.dominio.SemestreLetivo;
import br.mackenzie.academico.dominio.Turma;
import br.mackenzie.academico.excecao.AlunoNaoEncontradoException;
import br.mackenzie.academico.excecao.CalendarioNaoEncontradoException;
import br.mackenzie.academico.excecao.ComponenteCurricularNaoEncontradoException;
import br.mackenzie.academico.excecao.CursoNaoEncontradoException;
import br.mackenzie.academico.excecao.EmentaNaoEnconradaException;
import br.mackenzie.academico.excecao.FaculdadeNaoEncontradaException;
import br.mackenzie.academico.excecao.GradeCurricularNaoEncontradaException;
import br.mackenzie.academico.excecao.MatriculaNaoEncontradaException;
import br.mackenzie.academico.excecao.OferecimentoNaoEncontradoException;
import br.mackenzie.academico.excecao.PlanoAulaNaoEncontradoException;
import br.mackenzie.academico.excecao.PlanoEnsinoNaoEncontradoException;
import br.mackenzie.academico.excecao.ProfessorNaoEncontradoException;
import br.mackenzie.academico.excecao.ProjetoPedagogicoNaoEncontradoException;
import br.mackenzie.academico.excecao.TurmaNaoEncontradaException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo implements
        InterfaceAluno,
        InterfaceCalendarioLetivo,
        InterfaceComponenteCurricular,
        InterfaceConsulta,
        InterfaceCurso,
        InterfaceEmenta,
        InterfaceFaculdade,
        InterfaceGradeCurricular,
        InterfaceMatricula,
        InterfaceOferecimento,
        InterfacePlanoAula,
        InterfacePlanoEnsino,
        InterfaceProfessor,
        InterfaceProjetoPedagogico,
        InterfaceSemestreLetivo,
        InterfaceTurma {

    private List<Aluno> alunos;
    private List<CalendarioLetivo> calendarios;
    private List<ComponenteCurricular> componentes;
    private List<Curso> cursos;
    private List<Ementa> ementas;
    private List<Faculdade> faculdades;
    private List<GradeCurricular> grades;
    private List<Matricula> matriculas;
    private List<Oferecimento> oferecimentos;
    private List<PlanoAula> planosAula;
    private List<PlanoEnsino> planosEnsino;
    private List<Professor> professores;
    private List<ProjetoPedagogico> projetos;
    private List<SemestreLetivo> semestres;
    private List<Turma> turmas;

    private static Modelo instanciaUnica;

    public static Modelo getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Modelo();
        }
        return instanciaUnica;
    }

    public void persisteDados() {
        if (alunos != null) {
            persiste(alunos, Aluno.class);
        }
        if (calendarios != null) {
            persiste(calendarios, CalendarioLetivo.class);
        }
        if (componentes != null) {
            persiste(componentes, ComponenteCurricular.class);
        }
        if (cursos != null) {
            persiste(cursos, Curso.class);
        }
        if (ementas != null) {
            persiste(ementas, Ementa.class);
        }
        if (faculdades != null) {
            persiste(faculdades, Faculdade.class);
        }
        if (grades != null) {
            persiste(grades, GradeCurricular.class);
        }
        if (matriculas != null) {
            persiste(matriculas, Matricula.class);
        }
        if (oferecimentos != null) {
            persiste(oferecimentos, Oferecimento.class);
        }
        //if (planosAula != null) {
        //    persiste(planosAula, PlanosAula.class);
        //}
        if (planosEnsino != null) {
            persiste(planosEnsino, PlanoEnsino.class);
        }
        if (professores != null) {
            persiste(professores, Professor.class);
        }
        if (projetos != null) {
            persiste(projetos, ProjetoPedagogico.class);
        }
        if (semestres != null) {
            persiste(semestres, SemestreLetivo.class);
        }
        if (turmas != null) {
            persiste(turmas, Turma.class);
        }

    }

    public void carregaDados() {
        faculdades = carrega(Faculdade.class);
        cursos = carrega(Curso.class);
        turmas = carrega(Turma.class);
        componentes = carrega(ComponenteCurricular.class);
        oferecimentos = carrega(Oferecimento.class);
        alunos = carrega(Aluno.class);
        matriculas = carrega(Matricula.class);
        ementas = carrega(Ementa.class);
    }

    public <T> List<T> carrega(Class<T> type) {
        List<T> list = new ArrayList<T>();
        try {
            FileInputStream fis = new FileInputStream(type.getName() + ".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() != 0) {
                T e = (T) ois.readObject();
                list.add(e);
            }

            ois.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("Arquivo não encontrado!");
        }
        return list;
    }

    public <T> void persiste(List<T> list, Class<T> type) {
        try {
            FileOutputStream fos = new FileOutputStream(type.getName() + ".dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (T e : list) {
                oos.writeObject(e);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // MANIPULANDO ALUNOS
    @Override
    public void criaAluno(Aluno novoAluno) {
        if (alunos == null) {
            alunos = new ArrayList<>();
        }
        alunos.add(novoAluno);
    }

    @Override
    public List<Aluno> listaAlunos() {
        return alunos;
    }

    @Override
    public Aluno recuperaAluno(String tia) throws AlunoNaoEncontradoException {
        for (Aluno a : alunos) {
            if (a.getTIA().trim().equals(tia.trim())) {
                return a;
            }
        }
        throw new AlunoNaoEncontradoException();
    }

    @Override
    public void atualizaAluno(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getTIA().trim().equals(aluno.getTIA().trim())) {
                a.setNome(aluno.getNome());
            }
        }
    }

    @Override
    public void removeAluno(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getTIA().trim().equals(aluno.getTIA().trim())) {
                cursos.remove(a);
                break;
            }
        }
    }

    //MANIPULANDO CALENDÁRIOS LETIVOS
    @Override
    public void criaCalendarioLetivo(CalendarioLetivo novoCalendarioLetivo) {
        if (calendarios == null) {
            calendarios = new ArrayList<>();
        }
        calendarios.add(novoCalendarioLetivo);
    }

    @Override
    public List<CalendarioLetivo> listaCalendariosLetivos() {
        return calendarios;
    }

    @Override
    public CalendarioLetivo recuperaCalendarioLetivo(String eventos) throws CalendarioNaoEncontradoException {
        for (CalendarioLetivo c : calendarios) {
            if (c.getEventos().equals(eventos)) {
                return c;
            }
        }
        throw new CalendarioNaoEncontradoException();
    }

    @Override
    public void removeCalendarioLetivo(CalendarioLetivo cl) {
        for (CalendarioLetivo c : calendarios) {
            if (cl.equals(c)) {
                calendarios.remove(c);
            }
        }
    }

    @Override
    public void atualizaCalendarioLetivo(CalendarioLetivo cl) {
        for (CalendarioLetivo c : calendarios) {
            if (cl.equals(c)) {
                c.setEventos(cl.getEventos());
                c.setFeriados(cl.getFeriados());
            }
        }
    }

    // MANIPULANDO COMPONENTES CURRICULARES
    @Override
    public void criaComponenteCurricular(ComponenteCurricular componente) {
        if (componentes == null) {
            componentes = new ArrayList<>();
        }
        componentes.add(componente);
    }

    @Override
    public List<ComponenteCurricular> listaComponentesCurriculares() {
        return componentes;
    }

    @Override
    public ComponenteCurricular recuperaComponenteCurricular(String codigo) throws ComponenteCurricularNaoEncontradoException {
        for (ComponenteCurricular c : componentes) {
            if (c.getCodigo().trim().equals(codigo.trim())) {
                return c;
            }
        }
        throw new ComponenteCurricularNaoEncontradoException();
    }

    @Override
    public void atualizaComponenteCurricular(ComponenteCurricular componente) {
        for (ComponenteCurricular c : componentes) {
            if (c.getCodigo().trim().equals(componente.getCodigo().trim())) {
                c.setNome(componente.getNome());
            }
        }
    }

    @Override
    public void removeComponenteCurricular(ComponenteCurricular componente) {
        for (ComponenteCurricular c : componentes) {
            if (c.getCodigo().trim().equals(componente.getCodigo().trim())) {
                componentes.remove(c);
                break;
            }
        }
    }

    // MANIPULANDO CURSOS
    @Override
    public void criaCurso(Curso curso) {
        if (cursos == null) {
            cursos = new ArrayList<>();
        }
        cursos.add(curso);
    }

    @Override
    public List<Curso> listaCursos() {
        return cursos;
    }

    @Override
    public Curso recuperaCurso(String nome) throws CursoNaoEncontradoException {
        for (Curso c : cursos) {
            if (c.getNome().trim().equals(nome.trim())) {
                return c;
            }
        }
        throw new CursoNaoEncontradoException();
    }

    @Override
    public void atualizaCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getNome().trim().equals(curso.getNome().trim())) {
                c.setNome(curso.getNome());
            }
        }
    }

    @Override
    public void removeCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getNome().trim().equals(curso.getNome().trim())) {
                cursos.remove(c);
                break;
            }
        }
    }

    //MANIPULANDO EMENTAS
    @Override
    public void criaEmenta(Ementa novaEmenta) {
        if (ementas == null) {
            ementas = new ArrayList<>();
        }
        ementas.add(novaEmenta);
    }

    @Override
    public List<Ementa> listaEmentas() {
        return ementas;
    }

    @Override
    public Ementa recuperaEmenta(String codigo) throws EmentaNaoEnconradaException {
        for (Ementa e : ementas) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        throw new EmentaNaoEnconradaException();
    }

    @Override
    public void removeEmenta(String codigo) {
        for (Ementa e : ementas) {
            if (e.getCodigo().equals(codigo)) {
                ementas.remove(e);
                break;
            }
        }
    }

    // MANIPULANDO FACULDADES
    @Override
    public void criaFaculdade(Faculdade faculdade) {
        if (faculdades == null) {
            faculdades = new ArrayList<>();
        }
        faculdades.add(faculdade);
    }

    @Override
    public List<Faculdade> listaFaculdades() {
        return faculdades;
    }

    @Override
    public Faculdade recuperaFaculdade(String cnpj) throws FaculdadeNaoEncontradaException {
        for (Faculdade f : faculdades) {
            if (f.getCNPJ().trim().equals(cnpj.trim())) {
                return f;
            }
        }
        throw new FaculdadeNaoEncontradaException();
    }

    @Override
    public void atualizaFaculdade(Faculdade faculdade) {
        for (Faculdade f : faculdades) {
            if (f.getCNPJ().trim().equals(faculdade.getCNPJ().trim())) {
                f.setEndereco(faculdade.getEndereco());
                f.setNome(faculdade.getNome());
                f.setTelefone(faculdade.getTelefone());
            }
        }
    }

    @Override
    public void removeFaculdade(Faculdade faculdade) {
        for (Faculdade f : faculdades) {
            if (f.getCNPJ().trim().equals(faculdade.getCNPJ().trim())) {
                faculdades.remove(f);
                break;
            }
        }
    }

    //MANIPULANDO GRADES CURRICULARES
    @Override
    public void criaGradeCurricular(GradeCurricular novaGradeCurricular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GradeCurricular> listaGradesCurriculares() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GradeCurricular recuperaGradeCurricular(String projetoPedagogico) throws GradeCurricularNaoEncontradaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizaGradeCurricular(GradeCurricular gradeCurricular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeGradeCurricular(GradeCurricular gradeCurricular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // MANIPULANDO MATRÍCULAS
    @Override
    public void criaMatricula(Matricula novaMatricula) {
        if (matriculas == null) {
            matriculas = new ArrayList<>();
        }
        matriculas.add(novaMatricula);
    }

    @Override
    public List<Matricula> listaMatriculas() {
        return matriculas;
    }

    @Override
    public Matricula recuperaMatricula(Aluno aluno, Oferecimento oferecimento) throws MatriculaNaoEncontradaException {
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(aluno) && m.getOferecimento().equals(oferecimento)) {
                return m;
            }
        }
        throw new MatriculaNaoEncontradaException();
    }

    @Override
    public void atualizaMatricula(Matricula matricula) {
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(matricula.getAluno()) && m.getOferecimento().equals(matricula.getOferecimento())) {
                m.setStatus(matricula.getStatus());
                m.setMediaFinal(matricula.getMediaFinal());
            }
        }
    }

    @Override
    public void removeMatricula(Matricula matricula) {
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(matricula.getAluno()) && m.getOferecimento().equals(matricula.getOferecimento())) {
                matriculas.remove(m);
                break;
            }
        }
    }

    @Override
    public List<Matricula> buscaMatriculasAluno(String tia) {
        List<Matricula> matriculasAluno = new ArrayList<>();
        for (Matricula m : matriculas) {
            if ((m.getAluno().getTIA().trim().equals(tia.trim()))) {
                matriculasAluno.add(m);
            }
        }
        return matriculasAluno;
    }

    // MANIPULANDO OFERECIMENTOS
    @Override
    public void criaOferecimento(Oferecimento oferecimento) {
        if (oferecimentos == null) {
            oferecimentos = new ArrayList<Oferecimento>();
        }
        oferecimentos.add(oferecimento);
    }

    @Override
    public List<Oferecimento> listaOferecimentos() {
        return oferecimentos;
    }

    @Override
    public List<Oferecimento> buscaOferecimentosTurma(String codigo_turma) {
        List<Oferecimento> oferecimentosTurma = new ArrayList<>();
        for (Oferecimento o : oferecimentos) {
            if ((o.getTurma().getCodigo().trim().equals(codigo_turma.trim()))) {
                oferecimentosTurma.add(o);
            }
        }
        return oferecimentosTurma;
    }

    @Override
    public Oferecimento recuperaOferecimento(String codigoTurma, String codigoComponenteCurricular) throws OferecimentoNaoEncontradoException {
        for (Oferecimento o : oferecimentos) {
            if ((o.getTurma().getCodigo().trim().equals(codigoTurma.trim()))
                    && (o.getComponenteCurricular().getCodigo().trim().equals(codigoComponenteCurricular.trim()))) {
                return o;
            }
        }
        throw new OferecimentoNaoEncontradoException();
    }

    @Override
    public void atualizaOferecimento(Oferecimento oferecimento) {
        for (Oferecimento o : oferecimentos) {
            if ((o.getTurma().getCodigo().trim().equals(oferecimento.getTurma().getCodigo().trim()))
                    && (o.getComponenteCurricular().getCodigo().trim().equals(oferecimento.getComponenteCurricular().getCodigo().trim()))) {
                o.setInformacoesAdicionais(oferecimento.getInformacoesAdicionais());
            }
        }
    }

    @Override
    public void removeOferecimento(Oferecimento oferecimento) {
        for (Oferecimento o : oferecimentos) {
            if ((o.getTurma().getCodigo().trim().equals(oferecimento.getTurma().getCodigo().trim()))
                    && (o.getComponenteCurricular().getCodigo().trim().equals(oferecimento.getComponenteCurricular().getCodigo().trim()))) {
                oferecimentos.remove(o);
                break;
            }
        }
    }

    //MANIPULANDO PLANOS DE AULA
    @Override
    public void criaPlanoAula(PlanoAula novoPlanoAula) {
        if (planosAula == null) {
            planosAula = new ArrayList<>();
        }
        planosAula.add(novoPlanoAula);
    }

    public List<PlanoAula> listaPlanosAula() {
        return planosAula;
    }

    public PlanoAula recuperaPlanoAula(Oferecimento oferecimento) throws PlanoAulaNaoEncontradoException {
        for(PlanoAula pa: planosAula){
            if(pa.getOferecimento().equals(oferecimento)){
                return pa;
            }
        }
        throw new PlanoAulaNaoEncontradoException();
    }

    public void atualizaPlanoAula(PlanoAula planoAula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removePlanoAula(PlanoAula planoAula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //MANUPILANDO PLANOS DE ENSINO
    @Override
    public void criaPlanoEnsino(PlanoEnsino novoPlanoEnsino) {
        if (planosEnsino == null) {
            planosEnsino = new ArrayList<>();
        }
        planosEnsino.add(novoPlanoEnsino);
    }

    @Override
    public List<PlanoEnsino> listaPlanos() {
        return planosEnsino;
    }

    @Override
    public PlanoEnsino recuperaPlanoEnsino(String codigoEmenta) throws PlanoEnsinoNaoEncontradoException {
        for (PlanoEnsino pe : planosEnsino) {
            if (pe.getCodigo().equals(codigoEmenta)) {
                return pe;
            }
        }
        return null;
    }

    @Override
    public void atualizaPlanoEnsino(PlanoEnsino planoEnsino) {
        for (PlanoEnsino pe : planosEnsino) {
            if (pe.getCodigo().equals(planoEnsino.getCodigo())) {
                pe.setConceitos(planoEnsino.getConceitos());
                pe.setConteudoProgramatico(planoEnsino.getConteudoProgramatico());
                pe.setCriteriosAvaliacao(planoEnsino.getCriteriosAvaliacao());
                pe.setHabilidades(planoEnsino.getHabilidades());
                pe.setMetodologia(planoEnsino.getMetodologia());
                pe.setValores(planoEnsino.getValores());
            }
        }
    }

    @Override
    public void removePlanoEnsino(PlanoEnsino planoEnsino) {
        for (PlanoEnsino pe : planosEnsino) {
            if (pe.getCodigo().equals(planoEnsino.getCodigo())) {
                planosEnsino.remove(pe);
            }
        }
    }

    //MANIPULANDO PROFESSORES
    @Override
    public void criaProfessor(Professor novoProfessor) {
        if (professores == null) {
            professores = new ArrayList<>();
        }
        professores.add(novoProfessor);
    }

    @Override
    public List<Professor> listaProfessores() {
        return professores;
    }

    @Override
    public Professor recuperaProfessor(String drt) throws ProfessorNaoEncontradoException {
        for (Professor p : professores) {
            if (p.getDRT().equals(drt)) {
                return p;
            }
        }
        throw new ProfessorNaoEncontradoException();
    }

    @Override
    public void atualizaProfessor(Professor professor) {
        for (Professor p : professores) {
            if (p.getDRT().equals(professor.getDRT())) {
                p.setNome(professor.getNome());
                p.setOferecimento(professor.getOferecimento());
            }
        }
    }

    @Override
    public void removeProfessor(Professor professor) {
        for (Professor p : professores) {
            if (p.getDRT().equals(professor.getDRT())) {
                professores.remove(p);
            }
        }
    }

    //MANIPULANDO PROJETOS PEDAGÓGICOS
    @Override
    public void criaProjetoPedagogico(ProjetoPedagogico novoProjeto) {
        if (projetos == null) {
            projetos = new ArrayList<>();
        }
        projetos.add(novoProjeto);
    }

    @Override
    public List<ProjetoPedagogico> listaProjetosPedagogicos() {
        return projetos;
    }

    @Override
    public ProjetoPedagogico recuperaProjetoPedagogico(String nomeCurso) throws ProjetoPedagogicoNaoEncontradoException {
        for (ProjetoPedagogico p : projetos) {
            if (p.getCurso().getNome().equals(nomeCurso)) {
                return p;
            }
        }
        throw new ProjetoPedagogicoNaoEncontradoException();
    }

    @Override
    public void atualizaProjetoPedagogico(ProjetoPedagogico projeto) {
        for (ProjetoPedagogico p : projetos) {
            if (p.getCurso().getNome().equals(projeto.getCurso().getNome())) {
                p.setJustificativa(projeto.getJustificativa());
                p.setPerfil(projeto.getPerfil());
            }
        }
    }

    @Override
    public void removeProjetoPedagogico(ProjetoPedagogico projeto) {
        for (ProjetoPedagogico p : projetos) {
            if (p.getCurso().getNome().equals(projeto.getCurso().getNome())) {
                projetos.remove(p);
            }
        }
    }

    //MANIPULANDO SEMESTRES LETIVOS
    @Override
    public void criaSemestreLetivo(SemestreLetivo novoSemestre) {
        if (semestres == null) {
            semestres = new ArrayList<>();
        }
        semestres.add(novoSemestre);
    }

    @Override
    public List<SemestreLetivo> listaSemestresLetivos() {
        return semestres;
    }

    @Override
    public SemestreLetivo recuperaSemestreLetivo(int ano, int semestre) {
        for (SemestreLetivo s : semestres) {
            if (s.getAno() == ano && s.getSemestre() == semestre) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void atualizaSemestreLetivo(int ano, int semestre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSemestreLetivo(SemestreLetivo s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // MANIPULANDO TURMAS
    @Override
    public void criaTurma(Turma turma) {
        if (turmas == null) {
            turmas = new ArrayList<>();
        }
        turmas.add(turma);
    }

    @Override
    public List<Turma> listaTurmas() {
        return turmas;
    }

    @Override
    public Turma recuperaTurma(String codigo) throws TurmaNaoEncontradaException {
        for (Turma t : turmas) {
            if (t.getCodigo().trim().equals(codigo.trim())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void atualizaTurma(Turma turma) {
        for (Turma t : turmas) {
            if (t.getCodigo().trim().equals(turma.getCodigo().trim())) {
                t.setPeriodoDeIngresso(turma.getPeriodoDeIngresso());
            }
        }
    }

    @Override
    public void removeTurma(Turma turma) {
        for (Turma t : turmas) {
            if (t.getCodigo().trim().equals(turma.getCodigo().trim())) {
                turmas.remove(t);
                break;
            }
        }
    }
}
