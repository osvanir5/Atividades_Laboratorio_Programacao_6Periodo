/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class PainelBoasVindas extends JPanel {

    public PainelBoasVindas() {
        setLayout(new BorderLayout());
        setBackground(Color.YELLOW);

        JLabel titulo = new JLabel("CONTROLE DE CLIENTES", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(0, 128, 0)); // verde
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(titulo, BorderLayout.NORTH);
        add(new LogoPanel(), BorderLayout.CENTER);
    }
}
