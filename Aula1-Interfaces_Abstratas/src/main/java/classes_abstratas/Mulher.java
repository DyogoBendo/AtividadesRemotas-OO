/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_abstratas;

import java.util.Date;

/**
 *
 * @author Dyogo
 */
public class Mulher extends Pessoa {

    @Override
    public int calculaIdade(Date data) {
        // implementar
        return 0;
    }
    public static void main(String[] args) {
        Mulher m = new Mulher();
        m.darNome("Josefa");
        System.out.println("Nome: " + m.nome);
    }
}
