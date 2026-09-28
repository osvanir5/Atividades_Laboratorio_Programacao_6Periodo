package biblioteca;

/**
 * Classe de MODELO: representa um membro (usuário) da biblioteca.
 */
public class Membro {

    private String nome;
    private String matricula;
    private String contato;

    public Membro(String nome, String matricula, String contato) {
        this.nome = nome;
        this.matricula = matricula;
        this.contato = contato;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    /** Texto exibido dentro do JComboBox da tela de empréstimos. */
    @Override
    public String toString() {
        return nome + " (mat. " + matricula + ")";
    }
}
