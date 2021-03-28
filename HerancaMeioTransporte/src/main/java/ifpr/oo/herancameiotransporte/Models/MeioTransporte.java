/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.herancameiotransporte.Models;

/**
 *
 * @author Dyogo
 */
public class MeioTransporte {
    String combustivel, locomocao, marca, modelo;
    float peso;
    int ano, tanque;
    
    public void abastecer(){
        
    }
    
    public boolean ligar(){
        return false;
    }
    
    public boolean mover(){
        return false;
    }
}
