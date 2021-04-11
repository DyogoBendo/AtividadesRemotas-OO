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
public class Cavalo extends Animal {
    
    
    public Cavalo(){
        this.id=1;
    }
    
    //Metodos

    @Override
    public void correr() {
        System.out.println("Cavalo correndo...");
    }

    @Override
    public void emitirSom() {
        System.out.println("IRRRIINN");
    }
}
