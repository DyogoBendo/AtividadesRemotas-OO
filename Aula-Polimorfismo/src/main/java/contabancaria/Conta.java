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
public class Conta {
    float saldo;
    
    public float saque(float valor ){
        return this.saldo - valor;
    }
}