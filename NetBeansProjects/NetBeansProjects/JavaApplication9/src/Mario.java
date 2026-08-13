/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Mario extends Heroi {

    public Mario(String nome, int vida, int energia) {
        super(nome, vida, energia);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " atacou com um salto!");
    }
}
