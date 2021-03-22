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
public class Cachorro extends Animal implements Acao {

    @Override
    public void darNome(String nome) {
        if (this.sexo.equals("M")){
            this.nome = nome + "inho";
        } else{
            this.nome = nome + "inha";
        }
    }

    @Override
    public void comer() {
        System.out.println("Auau osso auau");
    }

    @Override
    public void locomover() {
        System.out.println("Auau correr auau");
    }

    @Override
    public void emitirSom() {
        System.out.println("Auauauau");
    }

    @Override
    public boolean isAlto() {
        return this.altura > 1.20;
    }
    
}
