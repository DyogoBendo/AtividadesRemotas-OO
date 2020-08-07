/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade2.heranca_meio_transporte;

/**
 *
 * @author Dyogo
 * 
 * 
 */
public class Main {
    public static void main(String[] args) {
        MeioDeTransporte auto = new Automovel();
        MeioDeTransporte aviao = new Aviao();
        MeioDeTransporte barco = new Barco();
        MeioDeTransporte generico = new MeioDeTransporte("Fiat", "Uno", 654.5f, 2008);
        
        aviao.ligar_desligar();
        aviao.abastecer("querosene", 70);
        aviao.mover();
        
        System.out.println("");
        
        auto.mover();
        
        System.out.println("");
        
        barco.ligar_desligar();
        barco.mover();
        
        System.out.println("");
        
        generico.abastecer("Gasolina", 80);
        generico.mover();
        
        System.out.println("");
        
        aviao.mostrar_ficha();
        auto.mostrar_ficha();
        barco.mostrar_ficha();
        generico.mostrar_ficha();
    }
}
