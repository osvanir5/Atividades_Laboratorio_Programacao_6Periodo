/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Painel customizado que desenha um "logo" simples (retângulo
 * verde com um "U" branco), já que não há um arquivo de imagem
 * disponível. Substitua o conteúdo de paintComponent por um
 * ImageIcon real se desejar usar o logo oficial da instituição.
 */
public class LogoPanel extends JPanel {

    public LogoPanel() {
        setOpaque(false);
        setPreferredSize(new Dimension(160, 160));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int tamanho = 130;
        int x = (getWidth() - tamanho) / 2;
        int y = 10;

        // Fundo verde (arredondado)
        g2.setColor(new Color(90, 140, 130));
        g2.fillRoundRect(x, y, tamanho, tamanho, 15, 15);

        // Letra "U" branca desenhada como duas hastes + um arco
        g2.setColor(Color.WHITE);
        int margem = 30;
        int larguraHaste = 18;
        int alturaHaste = 55;

        // Haste esquerda
        g2.fillRect(x + margem, y + 20, larguraHaste, alturaHaste);
        // Haste direita
        g2.fillRect(x + tamanho - margem - larguraHaste, y + 20, larguraHaste, alturaHaste);
        // Curva inferior do "U"
        g2.fillArc(x + margem, y + 20 + alturaHaste - larguraHaste,
                tamanho - 2 * margem, larguraHaste * 2, 180, 180);

        g2.dispose();
    }
}
