/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;

public class Janela extends JFrame {

    // ---------------------------------------------------------
    // Atributos (item 3)
    // ---------------------------------------------------------
    private JLabel jlAgencia;
    private JTextField jtfAgencia;
    private JLabel jlConta;
    private JTextField jtfConta;
    private JSeparator jSeparator01;

    private JLabel jlNome;
    private JTextField jtfNome;
    private JLabel jlEndereco;
    private JTextField jtfEndereco;
    private JLabel jlTelefone;
    private JTextField jtfTelefone;
    private JLabel jlCpf;
    private JTextField jtfCpf;

    private JRadioButton jrbCorrente;
    private JRadioButton jrbPoupanca;
    private ButtonGroup bgContas;

    private JSeparator jSeparator02;

    private JButton jbConsultar;
    private JButton jbAtualizar;
    private JButton jbFechar;

    public Janela() {
        // ----- Configurações da Janela (item 1) -----
        setSize(400, 255);
        setTitle("Laboratório de Programação");
        setLocationRelativeTo(null); // abre centralizada
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout nulo para posicionar os componentes livremente
        getContentPane().setLayout(null);

        // ----- jlAgencia (item 4) -----
        jlAgencia = new JLabel("Código da Agência:");
        jlAgencia.setBounds(10, 10, 110, 18);
        getContentPane().add(jlAgencia);

        // ----- jtfAgencia (item 5) -----
        jtfAgencia = new JTextField();
        jtfAgencia.setBounds(125, 10, 50, 20);
        getContentPane().add(jtfAgencia);

        // ----- jlConta (item 6) -----
        jlConta = new JLabel("Número da Conta:");
        jlConta.setBounds(205, 10, 105, 18);
        getContentPane().add(jlConta);

        // ----- jtfConta (item 7) -----
        jtfConta = new JTextField();
        jtfConta.setBounds(315, 10, 60, 20);
        getContentPane().add(jtfConta);

        // ----- jSeparator01 (item 8) -----
        jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        getContentPane().add(jSeparator01);

        // ----- jlNome (item 9) -----
        jlNome = new JLabel("Nome:");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlNome);

        // ----- jtfNome (item 10) -----
        jtfNome = new JTextField();
        jtfNome.setBounds(75, 50, 300, 20);
        getContentPane().add(jtfNome);

        // ----- jlEndereco (item 11) -----
        jlEndereco = new JLabel("Endereço:");
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlEndereco);

        // ----- jtfEndereco (item 12) -----
        jtfEndereco = new JTextField();
        jtfEndereco.setBounds(75, 75, 300, 20);
        getContentPane().add(jtfEndereco);

        // ----- jlTelefone (item 13) -----
        jlTelefone = new JLabel("Telefone:");
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlTelefone);

        // ----- jtfTelefone (item 14) -----
        jtfTelefone = new JTextField();
        jtfTelefone.setBounds(75, 100, 300, 20);
        getContentPane().add(jtfTelefone);

        // ----- jlCpf (item 15) -----
        jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlCpf);

        // ----- jtfCpf (item 16) -----
        jtfCpf = new JTextField();
        jtfCpf.setBounds(75, 125, 300, 20);
        getContentPane().add(jtfCpf);

        // ----- jrbCorrente (item 17) -----
        jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setMnemonic(KeyEvent.VK_C); // atalho alt + c
        jrbCorrente.setSelected(true);
        getContentPane().add(jrbCorrente);

        // ----- jrbPoupanca (item 18) -----
        jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P); // atalho alt + p
        getContentPane().add(jrbPoupanca);

        // ----- bgContas (item 19) -----
        bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);

        // ----- jSeparator02 (item 20) -----
        jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        getContentPane().add(jSeparator02);

        // ----- jbConsultar (item 21) -----
        jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(35, 190, 100, 23);
        jbConsultar.setMnemonic(KeyEvent.VK_S); // atalho alt + s
        getContentPane().add(jbConsultar);

        // ----- jbAtualizar (item 22) -----
        jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(145, 190, 100, 23);
        jbAtualizar.setMnemonic(KeyEvent.VK_A); // atalho alt + a
        jbAtualizar.setEnabled(false);
        getContentPane().add(jbAtualizar);

        // ----- jbFechar (item 23) -----
        jbFechar = new JButton("Fechar");
        jbFechar.setBounds(225, 190, 100, 23);
        jbFechar.setMnemonic(KeyEvent.VK_F); // atalho alt + f
        jbFechar.addActionListener(e -> dispose());
        getContentPane().add(jbFechar);
    }
}