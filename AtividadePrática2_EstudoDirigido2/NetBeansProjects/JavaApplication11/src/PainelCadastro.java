/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.*;
import java.awt.*;

public class PainelCadastro extends JPanel {

    public PainelCadastro(TelaPrincipal tela) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("CADASTRO DE CLIENTE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(0, 70, 140));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titulo, BorderLayout.NORTH);

        // Formulário simples ao centro
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fontRotulo = new Font("Arial", Font.PLAIN, 14);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(fontRotulo);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formulario.add(lblNome, gbc);

        JTextField txtNome = new JTextField(20);
        gbc.gridx = 1;
        formulario.add(txtNome, gbc);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setFont(fontRotulo);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formulario.add(lblCidade, gbc);

        JTextField txtCidade = new JTextField(20);
        gbc.gridx = 1;
        formulario.add(txtCidade, gbc);

        add(formulario, BorderLayout.CENTER);

        // Painel de botões: Salvar e Cancelar
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        painelBotoes.setBackground(Color.WHITE);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        btnSalvar.setFont(new Font("Arial", Font.BOLD, 13));
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));

        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso!");
            tela.mostrarPainel(TelaPrincipal.BOAS_VINDAS);
        });

        btnCancelar.addActionListener(e -> tela.mostrarPainel(TelaPrincipal.BOAS_VINDAS));

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        add(painelBotoes, BorderLayout.SOUTH);
    }
}