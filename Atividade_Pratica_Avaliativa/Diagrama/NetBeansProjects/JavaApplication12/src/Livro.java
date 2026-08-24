/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Livro implements IListavel {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String listarInfo() {
        String status = disponivel ? "Disponível" : "Emprestado";
        return String.format("Livro [ID: %d | Título: %s | Autor: %s | ISBN: %s | Status: %s]",
                id, titulo, autor, isbn, status);
    }
}