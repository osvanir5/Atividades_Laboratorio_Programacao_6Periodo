/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
/**
 * Representa um funcionário da biblioteca.
 * Herda de Pessoa.
 */
public class Funcionario extends Pessoa {
    private String cargo;
    private String matricula;

    public Funcionario(int id, String nome, String email, String cargo, String matricula) {
        super(id, nome, email);
        this.cargo = cargo;
        this.matricula = matricula;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public String listarInfo() {
        return String.format("Funcionário [ID: %d | Nome: %s | Email: %s | Cargo: %s | Matrícula: %s]",
                getId(), getNome(), getEmail(), cargo, matricula);
    }
}
