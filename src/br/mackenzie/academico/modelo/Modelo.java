//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.modelo;

import br.mackenzie.academico.dominio.Aluno;
import br.mackenzie.academico.dominio.ComponenteCurricular;
import br.mackenzie.academico.dominio.Curso;
import br.mackenzie.academico.dominio.Ementa;
import br.mackenzie.academico.dominio.Faculdade;
import br.mackenzie.academico.dominio.Matricula;
import br.mackenzie.academico.dominio.Oferecimento;
import br.mackenzie.academico.dominio.Turma;
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

public class Modelo implements InterfaceAluno,
        InterfaceComponenteCurricular,
        InterfaceConsulta,
        InterfaceCurso,
        InterfaceEmenta,
        InterfaceFaculdade,
        InterfaceMatricula,
        InterfaceOferecimento,
        InterfaceTurma {

    private List<Faculdade> faculdades;
    private List<Curso> cursos;
    private List<Turma> turmas;
    private List<ComponenteCurricular> componentes;
    private List<Oferecimento> oferecimentos;
    private List<Aluno> alunos;
    private List<Matricula> matriculas;
    private List<Ementa> ementas;
    private static Modelo instanciaUnica;

    public static Modelo getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Modelo();
        }
        return instanciaUnica;
    }

    public void persisteDados() {

        if (faculdades != null) {
            persiste(faculdades, Faculdade.class);
        }
        if (cursos != null) {
            persiste(cursos, Curso.class);
        }
        if (turmas != null) {
            persiste(turmas, Turma.class);
        }
        if (componentes != null) {
            persiste(componentes, ComponenteCurricular.class);
        }
        if (oferecimentos != null) {
            persiste(oferecimentos, Oferecimento.class);
        }
        if (alunos != null) {
            persiste(alunos, Aluno.class);
        }
        if (matriculas != null) {
            persiste(matriculas, Matricula.class);
        }
        if (ementas != null) {
            persiste(ementas, Ementa.class);
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
    public Faculdade recuperaFaculdade(String cnpj) {
        for (Faculdade f : faculdades) {
            if (f.getCNPJ().trim().equals(cnpj.trim())) {
                return f;
            }
        }
        return null;
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
    public Curso recuperaCurso(String nome) {
        for (Curso c : cursos) {
            if (c.getNome().trim().equals(nome.trim())) {
                return c;
            }
        }
        return null;
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
    public Turma recuperaTurma(String codigo) {
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
    public ComponenteCurricular recuperaComponenteCurricular(String codigo) {
        for (ComponenteCurricular c : componentes) {
            if (c.getCodigo().trim().equals(codigo.trim())) {
                return c;
            }
        }
        return null;
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
    public Oferecimento recuperaOferecimento(String codigoTurma, String codigoComponenteCurricular) {
        for (Oferecimento o : oferecimentos) {
            if ((o.getTurma().getCodigo().trim().equals(codigoTurma.trim()))
                    && (o.getComponenteCurricular().getCodigo().trim().equals(codigoComponenteCurricular.trim()))) {
                return o;
            }
        }
        return null;
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
    public Aluno recuperaAluno(String tia) {
        for (Aluno a : alunos) {
            if (a.getTIA().trim().equals(tia.trim())) {
                return a;
            }
        }
        return null;
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
    public Matricula recuperaMatricula(Aluno aluno, Oferecimento oferecimento) {
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(aluno) && m.getOferecimento().equals(oferecimento)) {
                return m;
            }
        }
        return null;
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
    public Ementa recuperaEmenta(String codigo) {
        for (Ementa e : ementas) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
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
}
