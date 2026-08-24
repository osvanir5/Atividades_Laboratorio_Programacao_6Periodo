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

public class Membro extends Pessoa {
    private String telefone;
    private List<Livro> livrosEmprestados;
    private static final int LIMITE = 3;

    public Membro(int id, String nome, String email, String telefone) {
        super(id, nome, email);
        this.telefone = telefone;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public List<Livro> getLivrosEmprestados() { return livrosEmprestados; }

    public void adicionarLivro(Livro livro) throws LimiteEmprestimosException {
        if (livrosEmprestados.size() >= LIMITE) {
            throw new LimiteEmprestimosException(
                "Membro já possui o limite de " + LIMITE + " livros emprestados.");
        }
        livrosEmprestados.add(livro);
    }

    public void removerLivro(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    @Override
    public String listarInfo() {
        return String.format("Membro [ID: %d | Nome: %s | Email: %s | Telefone: %s | Empréstimos ativos: %d]",
                getId(), getNome(), getEmail(), telefone, livrosEmprestados.size());
    }
}
