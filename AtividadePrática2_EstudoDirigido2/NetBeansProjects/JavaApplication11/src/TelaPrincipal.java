/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class TelaPrincipal extends JFrame {

    // Nomes usados para identificar os painéis dentro do CardLayout
    public static final String BOAS_VINDAS = "boasVindas";
    public static final String CADASTRO = "cadastro";

    private final CardLayout cardLayout;
    private final JPanel painelContainer;

    public TelaPrincipal() {
        super("MENU, ITENS DE MENU, FONTES");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        // Barra de menus (delegada para a classe MenuPrincipal)
        setJMenuBar(new MenuPrincipal(this));

        // Container central que alterna entre os painéis
        cardLayout = new CardLayout();
        painelContainer = new JPanel(cardLayout);

        painelContainer.add(new PainelBoasVindas(), BOAS_VINDAS);
        painelContainer.add(new PainelCadastro(this), CADASTRO);

        add(painelContainer);

        cardLayout.show(painelContainer, BOAS_VINDAS);

        setVisible(true);
    }

    /**
     * Alterna o painel visível dentro do container central.
     * @param nomePainel BOAS_VINDAS ou CADASTRO
     */
    public void mostrarPainel(String nomePainel) {
        cardLayout.show(painelContainer, nomePainel);
    }
}