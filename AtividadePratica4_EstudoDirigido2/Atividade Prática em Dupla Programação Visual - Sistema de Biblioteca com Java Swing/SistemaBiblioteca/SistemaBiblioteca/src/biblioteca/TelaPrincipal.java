package biblioteca;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Tela inicial (menu). Contém o método main e os botões que abrem
 * as outras telas. É a única tela que fecha o programa (EXIT_ON_CLOSE);
 * as demais usam DISPOSE_ON_CLOSE e só fecham a própria janela.
 */
public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Título no topo
        JLabel titulo = new JLabel("Sistema de Biblioteca", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(20f));

        // Botões do menu
        JButton btnLivros = new JButton("Gerenciamento de Livros");
        JButton btnMembros = new JButton("Gerenciamento de Membros");
        JButton btnEmprestimos = new JButton("Gerenciamento de Empréstimos");
        JButton btnSair = new JButton("Sair");

        // Cada botão cria e exibe a tela correspondente (navegação).
        // As telas compartilham os dados por meio de Biblioteca.getInstance().
        btnLivros.addActionListener(e -> new TelaLivros().setVisible(true));
        btnMembros.addActionListener(e -> new TelaMembros().setVisible(true));
        btnEmprestimos.addActionListener(e -> new TelaEmprestimos().setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));

        // Layout: uma coluna com 5 linhas (título + 4 botões)
        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        painel.add(titulo);
        painel.add(btnLivros);
        painel.add(btnMembros);
        painel.add(btnEmprestimos);
        painel.add(btnSair);

        add(painel);
        pack();                    // ajusta o tamanho aos componentes
        setLocationRelativeTo(null); // centraliza na tela
    }

    public static void main(String[] args) {
        try { // visual nativo do sistema operacional
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignorada) { }
        // Swing deve ser iniciado na thread de eventos
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
