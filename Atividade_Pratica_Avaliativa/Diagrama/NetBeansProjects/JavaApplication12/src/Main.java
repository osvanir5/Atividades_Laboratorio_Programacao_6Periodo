/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========== BIBLIOTECA ==========");
            System.out.println("1. Incluir Livro");
            System.out.println("2. Editar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Listar Livros");
            System.out.println("5. Cadastrar Membro");
            System.out.println("6. Editar Membro");
            System.out.println("7. Listar Membros");
            System.out.println("8. Realizar Empréstimo");
            System.out.println("9. Encerrar Empréstimo");
            System.out.println("10. Listar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        bib.incluirLivro(titulo, autor, isbn);
                        break;

                    case 2:
                        System.out.print("ID do livro: ");
                        int idL = sc.nextInt(); sc.nextLine();
                        System.out.print("Novo título: ");
                        String nt = sc.nextLine();
                        System.out.print("Novo autor: ");
                        String na = sc.nextLine();
                        System.out.print("Novo ISBN: ");
                        String ni = sc.nextLine();
                        bib.editarLivro(idL, nt, na, ni);
                        break;

                    case 3:
                        System.out.print("ID do livro a remover: ");
                        bib.removerLivro(sc.nextInt());
                        break;

                    case 4:
                        bib.listarLivros();
                        break;

                    case 5:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Telefone: ");
                        String tel = sc.nextLine();
                        bib.cadastrarMembro(nome, email, tel);
                        break;

                    case 6:
                        System.out.print("ID do membro: ");
                        int idM = sc.nextInt(); sc.nextLine();
                        System.out.print("Novo nome: ");
                        String nn = sc.nextLine();
                        System.out.print("Novo email: ");
                        String ne = sc.nextLine();
                        System.out.print("Novo telefone: ");
                        String ntel = sc.nextLine();
                        bib.editarMembro(idM, nn, ne, ntel);
                        break;

                    case 7:
                        bib.listarMembros();
                        break;

                    case 8:
                        System.out.print("ID do livro: ");
                        int idLivro = sc.nextInt();
                        System.out.print("ID do membro: ");
                        int idMembro = sc.nextInt();
                        bib.realizarEmprestimo(idLivro, idMembro);
                        break;

                    case 9:
                        System.out.print("ID do empréstimo: ");
                        bib.encerrarEmprestimo(sc.nextInt());
                        break;

                    case 10:
                        bib.listarEmprestimos();
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("? Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}