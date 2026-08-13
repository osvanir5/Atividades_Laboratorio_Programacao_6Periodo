/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) {

        Heroi goku = new Goku("Goku", 100, 100);
        Heroi sonic = new Sonic("Sonic", 100, 80);
        Heroi mario = new Mario("Mario", 100, 70);

        goku.apresentar();
        goku.atacar();

        System.out.println();

        sonic.apresentar();
        sonic.atacar();

        System.out.println();

        mario.apresentar();
        mario.atacar();
    }
}