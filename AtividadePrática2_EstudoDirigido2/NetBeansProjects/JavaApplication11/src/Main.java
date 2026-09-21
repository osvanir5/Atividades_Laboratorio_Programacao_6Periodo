/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Garante que a interface gráfica seja criada na thread correta (EDT)
        SwingUtilities.invokeLater(TelaPrincipal::new);
    }
}
