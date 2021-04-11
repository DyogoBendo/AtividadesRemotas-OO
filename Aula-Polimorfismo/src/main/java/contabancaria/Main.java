package contabancaria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Main {
    public static void main(String[] args) {
        Poupanca p = new Poupanca(500);
        Conta e = new Especial();
        
        System.out.println(p.saque(300, 50));
    }
}
