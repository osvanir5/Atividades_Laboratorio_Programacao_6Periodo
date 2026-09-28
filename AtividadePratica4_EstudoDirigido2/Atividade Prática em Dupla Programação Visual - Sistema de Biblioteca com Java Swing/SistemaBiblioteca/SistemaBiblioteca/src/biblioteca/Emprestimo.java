package biblioteca;

import java.time.LocalDate;

/**
 * Classe de MODELO: liga um Livro a um Membro em uma data.
 * Um empréstimo está ATIVO enquanto dataDevolucao for null.
 */
public class Emprestimo {

    private Livro livro;
    private Membro membro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao; // null = ainda não devolvido

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
        livro.setDisponivel(false); // o livro fica indisponível
    }

    /** Encerra o empréstimo: registra a devolução e libera o livro. */
    public void encerrar() {
        this.dataDevolucao = LocalDate.now();
        livro.setDisponivel(true);
    }

    public boolean isAtivo() { return dataDevolucao == null; }

    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }

    public Membro getMembro() { return membro; }
    public void setMembro(Membro membro) { this.membro = membro; }

    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(LocalDate d) { this.dataEmprestimo = d; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate d) { this.dataDevolucao = d; }
}
