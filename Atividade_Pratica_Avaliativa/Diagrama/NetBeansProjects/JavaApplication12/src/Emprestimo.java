/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import java.time.LocalDate;

public class Emprestimo implements IListavel {
    private int id;
    private Livro livro;
    private Membro membro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(int id, Livro livro, Membro membro) {
        this.id = id;
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    public int getId() { return id; }
    public Livro getLivro() { return livro; }
    public Membro getMembro() { return membro; }
    public boolean isAtivo() { return ativo; }

    public void encerrar() {
        this.ativo = false;
        this.dataDevolucao = LocalDate.now();
        this.livro.setDisponivel(true);
        this.membro.removerLivro(this.livro);
    }

    @Override
    public String listarInfo() {
        String status = ativo ? "Ativo" : "Encerrado";
        String devolucao = (dataDevolucao != null) ? dataDevolucao.toString() : "-";
        return String.format("Empréstimo [ID: %d | Livro: %s | Membro: %s | Data: %s | Devolução: %s | Status: %s]",
                id, livro.getTitulo(), membro.getNome(), dataEmprestimo, devolucao, status);
    }
}
