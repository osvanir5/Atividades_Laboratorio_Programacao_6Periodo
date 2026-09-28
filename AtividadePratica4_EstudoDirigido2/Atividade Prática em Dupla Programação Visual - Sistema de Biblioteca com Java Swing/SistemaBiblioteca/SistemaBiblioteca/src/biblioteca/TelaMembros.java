package biblioteca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de gerenciamento de membros.
 * Mesma estrutura de TelaLivros: formulário + botões + JTable.
 * Cada linha da tabela corresponde ao mesmo índice de Biblioteca.getMembros().
 */
public class TelaMembros extends JFrame {

    private final ArrayList<Membro> membros = Biblioteca.getInstance().getMembros();

    private final JTextField txtNome = new JTextField(20);
    private final JTextField txtMatricula = new JTextField(20);
    private final JTextField txtContato = new JTextField(20);

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
            new String[]{"Nome", "Matrícula", "Contato"}, 0) {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };
    private final JTable tabela = new JTable(modeloTabela);

    public TelaMembros() {
        setTitle("Gerenciamento de Membros");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ----- Formulário -----
        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.add(new JLabel("Nome:"));      form.add(txtNome);
        form.add(new JLabel("Matrícula:")); form.add(txtMatricula);
        form.add(new JLabel("Contato:"));   form.add(txtContato);

        // ----- Botões -----
        JButton btnCadastrar = new JButton("Cadastrar membro");
        JButton btnEditar = new JButton("Editar membro");
        JButton btnListar = new JButton("Listar membros");
        JButton btnLimpar = new JButton("Limpar campos");

        btnCadastrar.addActionListener(e -> cadastrar());
        btnEditar.addActionListener(e -> editar());
        btnListar.addActionListener(e -> atualizarTabela());
        btnLimpar.addActionListener(e -> limparCampos());

        JPanel botoes = new JPanel(new FlowLayout());
        botoes.add(btnCadastrar);
        botoes.add(btnEditar);
        botoes.add(btnListar);
        botoes.add(btnLimpar);

        JPanel topo = new JPanel(new BorderLayout(5, 5));
        topo.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        topo.add(form, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        // Ao selecionar uma linha, preenche o formulário
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) preencherCamposComSelecionado();
        });

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        atualizarTabela();
        setSize(650, 420);
        setLocationRelativeTo(null);
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Membro m : membros) {
            modeloTabela.addRow(new Object[]{m.getNome(), m.getMatricula(), m.getContato()});
        }
    }

    private void preencherCamposComSelecionado() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) return;
        Membro m = membros.get(linha);
        txtNome.setText(m.getNome());
        txtMatricula.setText(m.getMatricula());
        txtContato.setText(m.getContato());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtMatricula.setText("");
        txtContato.setText("");
        tabela.clearSelection();
    }

    private void aviso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private boolean camposValidos() {
        if (txtNome.getText().trim().isEmpty() || txtMatricula.getText().trim().isEmpty()
                || txtContato.getText().trim().isEmpty()) {
            aviso("Preencha todos os campos.");
            return false;
        }
        return true;
    }

    /** Botão "Cadastrar": cria um Membro e guarda no ArrayList. */
    private void cadastrar() {
        if (!camposValidos()) return;
        String matricula = txtMatricula.getText().trim();
        if (Biblioteca.getInstance().buscarMembroPorMatricula(matricula) != null) {
            aviso("Já existe um membro com esta matrícula.");
            return;
        }
        membros.add(new Membro(txtNome.getText().trim(), matricula, txtContato.getText().trim()));
        atualizarTabela();
        limparCampos();
    }

    /** Botão "Editar": altera o membro selecionado usando os setters. */
    private void editar() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            aviso("Selecione um membro na tabela.");
            return;
        }
        if (!camposValidos()) return;
        Membro m = membros.get(linha);
        String matricula = txtMatricula.getText().trim();
        Membro existente = Biblioteca.getInstance().buscarMembroPorMatricula(matricula);
        if (existente != null && existente != m) {
            aviso("Já existe outro membro com esta matrícula.");
            return;
        }
        m.setNome(txtNome.getText().trim());
        m.setMatricula(matricula);
        m.setContato(txtContato.getText().trim());
        atualizarTabela();
        limparCampos();
    }
}
