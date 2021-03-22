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
public class Pessoa extends Animal implements Acao {

    @Override
    public void darNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void comer() {
        System.out.println("Hmmmmmm pizza gostosa");
    }

    @Override
    public void locomover() {
        System.out.println("Gosto de andar de carro, moto e a pé!");
    }

    @Override
    public void emitirSom() {
        System.out.println("Olá, tudo bem?");
    }

    @Override
    public boolean isAlto() {
        return this.altura > 1.70;
    }
    
}
