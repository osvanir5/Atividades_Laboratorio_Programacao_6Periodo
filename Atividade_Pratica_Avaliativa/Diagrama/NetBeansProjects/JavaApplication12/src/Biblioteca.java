/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private int proxIdLivro = 1;
    private int proxIdMembro = 1;
    private int proxIdEmprestimo = 1;

    // ========== LIVROS ==========
    public void incluirLivro(String titulo, String autor, String isbn) {
        Livro livro = new Livro(proxIdLivro++, titulo, autor, isbn);
        livros.add(livro);
        System.out.println("? Livro incluído: " + livro.listarInfo());
    }

    public void editarLivro(int id, String titulo, String autor, String isbn) throws ItemNaoEncontradoException {
        Livro livro = buscarLivro(id);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setIsbn(isbn);
        System.out.println("? Livro editado: " + livro.listarInfo());
    }

    public void removerLivro(int id) throws ItemNaoEncontradoException {
        Livro livro = buscarLivro(id);
        if (!livro.isDisponivel()) {
            System.out.println("? Não é possível remover um livro que está emprestado.");
            return;
        }
        livros.remove(livro);
        System.out.println("? Livro removido com sucesso.");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("\n========== LISTA DE LIVROS ==========");
        for (Livro l : livros) {
            System.out.println(l.listarInfo());
        }
    }

    // ========== MEMBROS ==========
    public void cadastrarMembro(String nome, String email, String telefone) {
        Membro membro = new Membro(proxIdMembro++, nome, email, telefone);
        membros.add(membro);
        System.out.println("? Membro cadastrado: " + membro.listarInfo());
    }

    public void editarMembro(int id, String nome, String email, String telefone) throws ItemNaoEncontradoException {
        Membro membro = buscarMembro(id);
        membro.setNome(nome);
        membro.setEmail(email);
        membro.setTelefone(telefone);
        System.out.println("? Membro editado: " + membro.listarInfo());
    }

    public void listarMembros() {
        if (membros.isEmpty()) {
            System.out.println("Nenhum membro cadastrado.");
            return;
        }
        System.out.println("\n========== LISTA DE MEMBROS ==========");
        for (Membro m : membros) {
            System.out.println(m.listarInfo());
        }
    }

    // ========== EMPRÉSTIMOS ==========
    public void realizarEmprestimo(int idLivro, int idMembro)
            throws ItemNaoEncontradoException, LivroNaoDisponivelException, LimiteEmprestimosException {

        Livro livro = buscarLivro(idLivro);
        Membro membro = buscarMembro(idMembro);

        if (!livro.isDisponivel()) {
            throw new LivroNaoDisponivelException("O livro \"" + livro.getTitulo() + "\" não está disponível.");
        }

        membro.adicionarLivro(livro);
        livro.setDisponivel(false);

        Emprestimo emp = new Emprestimo(proxIdEmprestimo++, livro, membro);
        emprestimos.add(emp);
        System.out.println("? Empréstimo realizado: " + emp.listarInfo());
    }

    public void encerrarEmprestimo(int idEmprestimo) throws ItemNaoEncontradoException {
        Emprestimo emp = buscarEmprestimo(idEmprestimo);
        if (!emp.isAtivo()) {
            System.out.println("? Este empréstimo já está encerrado.");
            return;
        }
        emp.encerrar();
        System.out.println("? Empréstimo encerrado: " + emp.listarInfo());
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        System.out.println("\n========== LISTA DE EMPRÉSTIMOS ==========");
        for (Emprestimo e : emprestimos) {
            System.out.println(e.listarInfo());
        }
    }

    // ========== Métodos auxiliares ==========
    private Livro buscarLivro(int id) throws ItemNaoEncontradoException {
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        throw new ItemNaoEncontradoException("Livro com ID " + id + " não encontrado.");
    }

    private Membro buscarMembro(int id) throws ItemNaoEncontradoException {
        for (Membro m : membros) {
            if (m.getId() == id) return m;
        }
        throw new ItemNaoEncontradoException("Membro com ID " + id + " não encontrado.");
    }

    private Emprestimo buscarEmprestimo(int id) throws ItemNaoEncontradoException {
        for (Emprestimo e : emprestimos) {
            if (e.getId() == id) return e;
        }
        throw new ItemNaoEncontradoException("Empréstimo com ID " + id + " não encontrado.");
    }
}