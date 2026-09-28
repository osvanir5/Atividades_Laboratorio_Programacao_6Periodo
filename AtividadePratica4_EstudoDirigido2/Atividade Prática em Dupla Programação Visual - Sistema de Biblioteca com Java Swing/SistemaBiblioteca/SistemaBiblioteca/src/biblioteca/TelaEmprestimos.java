package biblioteca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de gerenciamento de empréstimos.
 * - Dois JComboBox: um com os livros DISPONÍVEIS e outro com os membros.
 * - "Realizar empréstimo" cria um objeto Emprestimo (o livro fica indisponível).
 * - "Encerrar empréstimo" encerra o empréstimo selecionado na tabela
 *   (o livro volta a ficar disponível).
 * - A JTable lista empréstimos ativos e finalizados.
 */
public class TelaEmprestimos extends JFrame {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final Biblioteca biblioteca = Biblioteca.getInstance();
    private final ArrayList<Emprestimo> emprestimos = biblioteca.getEmprestimos();

    private final JComboBox<Livro> cbLivro = new JComboBox<>();
    private final JComboBox<Membro> cbMembro = new JComboBox<>();

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
            new String[]{"Livro", "Membro", "Empréstimo", "Devolução", "Situação"}, 0) {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };
    private final JTable tabela = new JTable(modeloTabela);

    public TelaEmprestimos() {
        setTitle("Gerenciamento de Empréstimos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ----- Seleção de livro e membro -----
        JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
        form.add(new JLabel("Livro (disponíveis):")); form.add(cbLivro);
        form.add(new JLabel("Membro:"));              form.add(cbMembro);

        // ----- Botões -----
        JButton btnRealizar = new JButton("Realizar empréstimo");
        JButton btnEncerrar = new JButton("Encerrar empréstimo selecionado");
        btnRealizar.addActionListener(e -> realizar());
        btnEncerrar.addActionListener(e -> encerrar());

        JPanel botoes = new JPanel(new FlowLayout());
        botoes.add(btnRealizar);
        botoes.add(btnEncerrar);

        JPanel topo = new JPanel(new BorderLayout(5, 5));
        topo.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        topo.add(form, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Sempre que a janela voltar ao foco, recarrega combos e tabela
        // (o usuário pode ter cadastrado livros/membros em outra tela).
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                atualizarTudo();
            }
        });

        atualizarTudo();
        setSize(780, 420);
        setLocationRelativeTo(null);
    }

    private void atualizarTudo() {
        recarregarCombos();
        atualizarTabela();
    }

    /** Preenche os JComboBox com objetos do modelo (usam o toString()). */
    private void recarregarCombos() {
        cbLivro.removeAllItems();
        for (Livro l : biblioteca.livrosDisponiveis()) cbLivro.addItem(l);
        cbMembro.removeAllItems();
        for (Membro m : biblioteca.getMembros()) cbMembro.addItem(m);
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Emprestimo e : emprestimos) {
            modeloTabela.addRow(new Object[]{
                e.getLivro().getTitulo(),
                e.getMembro().getNome(),
                e.getDataEmprestimo().format(FORMATO),
                e.getDataDevolucao() == null ? "-" : e.getDataDevolucao().format(FORMATO),
                e.isAtivo() ? "Ativo" : "Finalizado"});
        }
    }

    private void aviso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    /** Botão "Realizar empréstimo". */
    private void realizar() {
        Livro livro = (Livro) cbLivro.getSelectedItem();
        Membro membro = (Membro) cbMembro.getSelectedItem();
        if (livro == null || membro == null) {
            aviso("É preciso ter ao menos um livro disponível e um membro cadastrado.");
            return;
        }
        biblioteca.realizarEmprestimo(livro, membro);
        atualizarTudo(); // o livro emprestado some do combo
    }

    /** Botão "Encerrar empréstimo": usa a linha selecionada da tabela. */
    private void encerrar() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            aviso("Selecione um empréstimo na tabela.");
            return;
        }
        Emprestimo e = emprestimos.get(linha);
        if (!e.isAtivo()) {
            aviso("Este empréstimo já foi finalizado.");
            return;
        }
        e.encerrar();
        atualizarTudo(); // o livro volta a aparecer no combo
    }
}
