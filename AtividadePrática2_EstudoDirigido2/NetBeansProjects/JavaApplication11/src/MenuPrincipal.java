/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuPrincipal extends JMenuBar {

    public MenuPrincipal(TelaPrincipal tela) {

        // ----- Menu Arquivo -----
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemNovo = new JMenuItem("Novo");
        JMenuItem itemSair = new JMenuItem("Sair");

        itemNovo.addActionListener(e -> tela.mostrarPainel(TelaPrincipal.CADASTRO));
        itemSair.addActionListener(e -> System.exit(0));

        menuArquivo.add(itemNovo);
        menuArquivo.add(itemSair);

        // ----- Menu Relatório -----
        JMenu menuRelatorio = new JMenu("Relatório");
        JMenuItem itemCliente = new JMenuItem("Cliente");
        JMenuItem itemFornecedor = new JMenuItem("Fornecedor");

        itemCliente.addActionListener(e ->
                JOptionPane.showMessageDialog(tela, "Relatório de clientes"));
        itemFornecedor.addActionListener(e ->
                JOptionPane.showMessageDialog(tela, "Relatório de fornecedores"));

        menuRelatorio.add(itemCliente);
        menuRelatorio.add(itemFornecedor);

        // ----- Menu Sobre -----
        JMenu menuSobre = new JMenu("Sobre");
        JMenuItem itemInfo = new JMenuItem("Info");

        itemInfo.addActionListener(e ->
                JOptionPane.showMessageDialog(tela,
                        "Trabalho desenvolvido por: Osvanir\nDisciplina: Laboratorio de Programação",
                        "Sobre",
                        JOptionPane.INFORMATION_MESSAGE));

        menuSobre.add(itemInfo);

        add(menuArquivo);
        add(menuRelatorio);
        add(menuSobre);
    }
}
