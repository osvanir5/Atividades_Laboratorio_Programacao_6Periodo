package biblioteca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.Year;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de gerenciamento de livros.
 * Estrutura: formulário (campos) no topo + botões + JTable no centro.
 * Conexão com o modelo: cada linha da JTable corresponde ao mesmo
 * índice da lista Biblioteca.getLivros(), então "linha selecionada"
 * = "livro selecionado".
 */
public class TelaLivros extends JFrame {

    private final ArrayList<Livro> livros = Biblioteca.getInstance().getLivros();

    private final javax.swing.JTextField txtTitulo = new javax.swing.JTextField(20);
    private final javax.swing.JTextField txtAutor = new javax.swing.JTextField(20);
    private final javax.swing.JTextField txtAno = new javax.swing.JTextField(20);
    private final javax.swing.JTextField txtIsbn = new javax.swing.JTextField(20);

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
            new String[]{"Título", "Autor", "Ano", "ISBN", "Situação"}, 0) {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false; // a edição é feita pelo formulário, não na tabela
        }
    };
    private final JTable tabela = new JTable(modeloTabela);

    public TelaLivros() {
        setTitle("Gerenciamento de Livros");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // fecha só esta janela
        setLayout(new BorderLayout(10, 10));

        // ----- Formulário: rótulo + campo, em grade de 4 linhas x 2 colunas -----
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Título:"));   form.add(txtTitulo);
        form.add(new JLabel("Autor:"));    form.add(txtAutor);
        form.add(new JLabel("Ano:"));      form.add(txtAno);
        form.add(new JLabel("ISBN:"));     form.add(txtIsbn);

        // ----- Botões -----
        JButton btnAdicionar = new JButton("Adicionar livro");
        JButton btnEditar = new JButton("Editar livro selecionado");
        JButton btnRemover = new JButton("Remover livro");
        JButton btnLimpar = new JButton("Limpar campos");

        btnAdicionar.addActionListener(e -> adicionar());
        btnEditar.addActionListener(e -> editar());
        btnRemover.addActionListener(e -> remover());
        btnLimpar.addActionListener(e -> limparCampos());

        JPanel botoes = new JPanel(new FlowLayout());
        botoes.add(btnAdicionar);
        botoes.add(btnEditar);
        botoes.add(btnRemover);
        botoes.add(btnLimpar);

        // Painel do topo = formulário + botões
        JPanel topo = new JPanel(new BorderLayout(5, 5));
        topo.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        topo.add(form, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        // ----- Tabela: ao clicar numa linha, os dados vão para o formulário -----
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) preencherCamposComSelecionado();
        });

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        atualizarTabela();
        setSize(700, 450);
        setLocationRelativeTo(null);
    }

    /** Recria as linhas da JTable a partir da lista de livros. */
    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Livro l : livros) {
            modeloTabela.addRow(new Object[]{
                l.getTitulo(), l.getAutor(), l.getAno(), l.getIsbn(),
                l.isDisponivel() ? "Disponível" : "Emprestado"});
        }
    }

    private void preencherCamposComSelecionado() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) return;
        Livro l = livros.get(linha);
        txtTitulo.setText(l.getTitulo());
        txtAutor.setText(l.getAutor());
        txtAno.setText(String.valueOf(l.getAno()));
        txtIsbn.setText(l.getIsbn());
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAno.setText("");
        txtIsbn.setText("");
        tabela.clearSelection();
    }

    private void aviso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Valida os campos. Retorna o ano digitado ou -1 se algo estiver inválido
     * (nesse caso já exibe a mensagem ao usuário).
     */
    private int validarCampos() {
        if (txtTitulo.getText().trim().isEmpty() || txtAutor.getText().trim().isEmpty()
                || txtAno.getText().trim().isEmpty() || txtIsbn.getText().trim().isEmpty()) {
            aviso("Preencha todos os campos.");
            return -1;
        }
        try {
            int ano = Integer.parseInt(txtAno.getText().trim());
            if (ano < 0 || ano > Year.now().getValue() + 1) {
                aviso("Informe um ano válido.");
                return -1;
            }
            return ano;
        } catch (NumberFormatException ex) {
            aviso("O ano deve ser um número inteiro.");
            return -1;
        }
    }

    /** Botão "Adicionar livro": cria um objeto Livro e guarda no ArrayList. */
    private void adicionar() {
        int ano = validarCampos();
        if (ano < 0) return;
        String isbn = txtIsbn.getText().trim();
        if (Biblioteca.getInstance().buscarLivroPorIsbn(isbn) != null) {
            aviso("Já existe um livro com este ISBN.");
            return;
        }
        livros.add(new Livro(txtTitulo.getText().trim(), txtAutor.getText().trim(), ano, isbn));
        atualizarTabela();
        limparCampos();
    }

    /** Botão "Editar": altera o objeto selecionado usando os setters. */
    private void editar() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            aviso("Selecione um livro na tabela.");
            return;
        }
        int ano = validarCampos();
        if (ano < 0) return;
        Livro l = livros.get(linha);
        String isbn = txtIsbn.getText().trim();
        Livro existente = Biblioteca.getInstance().buscarLivroPorIsbn(isbn);
        if (existente != null && existente != l) { // ISBN de outro livro
            aviso("Já existe outro livro com este ISBN.");
            return;
        }
        l.setTitulo(txtTitulo.getText().trim());
        l.setAutor(txtAutor.getText().trim());
        l.setAno(ano);
        l.setIsbn(isbn);
        atualizarTabela();
        limparCampos();
    }

    /** Botão "Remover": tira o livro da lista (se não estiver emprestado). */
    private void remover() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            aviso("Selecione um livro na tabela.");
            return;
        }
        Livro l = livros.get(linha);
        if (Biblioteca.getInstance().livroTemEmprestimoAtivo(l)) {
            aviso("Este livro está emprestado e não pode ser removido.");
            return;
        }
        int r = JOptionPane.showConfirmDialog(this,
                "Remover o livro \"" + l.getTitulo() + "\"?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            livros.remove(linha);
            atualizarTabela();
            limparCampos();
        }
    }
}
