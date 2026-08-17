/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Principal {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        LivroFisico livro1 = new LivroFisico(
                "Dom Casmurro",
                "Machado de Assis",
                256,
                0.45
        );

        Ebook livro2 = new Ebook(
                "O Hobbit",
                "J.R.R. Tolkien",
                310,
                5.8
        );

        LivroFisico livro3 = new LivroFisico(
                "1984",
                "George Orwell",
                328,
                0.52
        );

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        System.out.println("=== LIVROS DA BIBLIOTECA ===");
        biblioteca.listarLivros();

        System.out.println("\n=== BUSCA POR TÍTULO ===");

        Livro encontrado = biblioteca.buscarLivroPorTitulo("O Hobbit");

        if (encontrado != null) {
            System.out.println("Livro encontrado:");
            encontrado.descricao();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
