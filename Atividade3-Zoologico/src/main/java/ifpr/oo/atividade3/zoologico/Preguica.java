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
public class Preguica extends Animal {
    
    
    public Preguica(){
        this.id=2;
    }
    
    //Metodos

    public void subirArvore() {
        System.out.println("Preguica subindo em arvores...");
    }

    @Override
    public void emitirSom() {
        System.out.println("AAAAAAHHHHZZZZ");
    }
}
