package biblioteca;

/**
 * Classe de MODELO: representa um livro do acervo.
 * Os atributos são privados (encapsulamento) e só são acessados
 * por meio de getters e setters.
 */
public class Livro {

    private String titulo;
    private String autor;
    private int ano;
    private String isbn;
    private boolean disponivel; // false enquanto houver empréstimo ativo

    public Livro(String titulo, String autor, int ano, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
        this.disponivel = true; // todo livro novo nasce disponível
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    /** Texto exibido dentro do JComboBox da tela de empréstimos. */
    @Override
    public String toString() {
        return titulo + " - " + autor + " (ISBN " + isbn + ")";
    }
}
