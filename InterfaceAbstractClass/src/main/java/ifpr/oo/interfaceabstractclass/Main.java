/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.interfaceabstractclass;

/**
 *
 * @author Dyogo
 */
public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        Cachorro c = new Cachorro();
        
        c.emitirSom();
        c.comer();
        c.locomover();
        
        p.emitirSom();
        p.comer();
        p.locomover();
        
        c.sexo = "F";
        c.darNome("Bell");
        System.out.println(c.nome);
        
        p.darNome("Eduardo");
        System.out.println(p.nome);
        
        p.altura = 1.64;
        System.out.println(p.nome + " é alto? " + p.isAlto());
        
        c.altura = 1.50;
        System.out.println(c.nome + " é alta? " + c.isAlto());
        
        c.idade = 4;
        c.calcularIdadeHumana(15);
        
        p.idade = 16;
        p.calcularIdadeHumana(1);
    }
}
