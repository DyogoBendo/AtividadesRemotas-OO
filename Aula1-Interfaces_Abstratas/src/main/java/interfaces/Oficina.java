/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Dyogo
 */
public class Oficina implements Manutencao {

    @Override
    public void trocaPneu() {
        
    }

    @Override
    public void trocaOleo() {
        
    }

    @Override
    public void abastecer(String combustivel) {
        System.out.println("Abastecido com " + combustivel);
    }
    
    public static void main(String[] args) {
        Oficina o = new Oficina();
        o.abastecer("Etanol");
    }
    
}
