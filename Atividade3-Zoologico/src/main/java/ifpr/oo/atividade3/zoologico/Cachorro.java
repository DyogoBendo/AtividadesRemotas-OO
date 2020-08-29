/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade3.zoologico;

/**
 *
 * @author Dyogo
 */
public class Cachorro extends Animal {
    
    
    public Cachorro(){
        this.id=0;
    }
    
    //Metodos
    @Override
    public void correr() {
        System.out.println("Cachorro correndo...");
    }

    @Override
    public void emitirSom() {
        System.out.println("AU AU AU!");
    }
}
