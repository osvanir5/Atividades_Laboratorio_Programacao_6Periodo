/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Goku extends Heroi {

    public Goku(String nome, int vida, int energia) {
        super(nome, vida, energia);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " lancou um Kamehameha!");
    }
}
