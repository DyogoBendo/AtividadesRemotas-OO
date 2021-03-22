/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabancaria;

/**
 *
 * @author Dyogo
 */
public class Poupanca extends Conta{
    public Poupanca(){
        
    }
    
    public Poupanca (float deposito){
        saldo = deposito;
    }
    
    public float saque(float val, int taxa){
        return saldo - val - taxa;
    }
}
