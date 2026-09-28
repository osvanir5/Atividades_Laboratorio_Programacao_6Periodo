package biblioteca;

import java.util.ArrayList;

/**
 * Classe que GUARDA os dados durante a execução (requisito: ArrayList).
 * Usa o padrão Singleton: existe uma única instância, compartilhada
 * por todas as telas. Assim, o livro cadastrado em TelaLivros aparece
 * automaticamente no JComboBox de TelaEmprestimos.
 */
public class Biblioteca {

    private static final Biblioteca INSTANCIA = new Biblioteca();

    private final ArrayList<Livro> livros = new ArrayList<>();
    private final ArrayList<Membro> membros = new ArrayList<>();
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    private Biblioteca() { } // construtor privado: ninguém cria outra biblioteca

    public static Biblioteca getInstance() { return INSTANCIA; }

    public ArrayList<Livro> getLivros() { return livros; }
    public ArrayList<Membro> getMembros() { return membros; }
    public ArrayList<Emprestimo> getEmprestimos() { return emprestimos; }

    // ---------- Livros ----------
    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro l : livros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) return l;
        }
        return null;
    }

    /** Devolve só os livros que podem ser emprestados agora. */
    public ArrayList<Livro> livrosDisponiveis() {
        ArrayList<Livro> lista = new ArrayList<>();
        for (Livro l : livros) {
            if (l.isDisponivel()) lista.add(l);
        }
        return lista;
    }

    // ---------- Membros ----------
    public Membro buscarMembroPorMatricula(String matricula) {
        for (Membro m : membros) {
            if (m.getMatricula().equalsIgnoreCase(matricula)) return m;
        }
        return null;
    }

    // ---------- Empréstimos ----------
    public Emprestimo realizarEmprestimo(Livro livro, Membro membro) {
        Emprestimo e = new Emprestimo(livro, membro);
        emprestimos.add(e);
        return e;
    }

    /** Impede remover um livro que está emprestado. */
    public boolean livroTemEmprestimoAtivo(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getLivro() == livro) return true;
        }
        return false;
    }
}
