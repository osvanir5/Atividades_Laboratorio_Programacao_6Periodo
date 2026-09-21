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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPessoa extends JFrame {

    private JTextField txtCpf;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JComboBox<String> cbEstado;
    private JComboBox<String> cbCargo;
    private JButton btnImprimir;

    public FormularioPessoa() {
        super("Formulário para cadastro de Pessoa");

        // Configurações gerais da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 260);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal com GridBagLayout para alinhar rótulos e campos
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 0 - Cpf
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel("Informe Cpf:"), gbc);

        txtCpf = new JTextField(15);
        gbc.gridx = 1;
        painel.add(txtCpf, gbc);

        // Linha 1 - Nome
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("Nome:"), gbc);

        txtNome = new JTextField(15);
        gbc.gridx = 1;
        painel.add(txtNome, gbc);

        // Linha 2 - Endereço
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel("Endereço:"), gbc);

        txtEndereco = new JTextField(15);
        gbc.gridx = 1;
        painel.add(txtEndereco, gbc);

        // Linha 3 - Estado
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel("Estado:"), gbc);

        String[] estados = {
                "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
                "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão",
                "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará",
                "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro",
                "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia",
                "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
        };
        cbEstado = new JComboBox<>(estados);
        cbEstado.setSelectedItem("Minas Gerais");
        gbc.gridx = 1;
        painel.add(cbEstado, gbc);

        // Linha 4 - Cargo
        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(new JLabel("Cargo:"), gbc);

        String[] cargos = {
                "Analista de Sistemas", "Gerente de Marketing", "Desenvolvedor",
                "Coordenador Financeiro", "Assistente Administrativo", "Diretor"
        };
        cbCargo = new JComboBox<>(cargos);
        gbc.gridx = 1;
        painel.add(cbCargo, gbc);

        // Linha 5 - Botão Imprimir Dados
        btnImprimir = new JButton("Imprimir Dados");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(btnImprimir, gbc);

        // Ação do botão: monta a mensagem e exibe em um JOptionPane
        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirDados();
            }
        });

        add(painel);
    }

    private void imprimirDados() {
        String cpf = txtCpf.getText();
        String nome = txtNome.getText();
        String endereco = txtEndereco.getText();
        String estado = (String) cbEstado.getSelectedItem();
        String cargo = (String) cbCargo.getSelectedItem();

        String mensagem = "Cpf: " + cpf + "\n"
                + "Nome: " + nome + "\n"
                + "Endereço: " + endereco + "\n"
                + "Estado: " + estado + "\n"
                + "Cargo: " + cargo;

        JOptionPane.showMessageDialog(
                this,
                mensagem,
                "Mensagem",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        // Garante que a interface gráfica seja criada na thread correta (EDT)
        SwingUtilities.invokeLater(() -> {
            FormularioPessoa formulario = new FormularioPessoa();
            formulario.setVisible(true);
        });
    }
}
