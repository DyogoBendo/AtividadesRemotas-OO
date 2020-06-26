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
public interface Manutencao {
    // Interfaces são muito úteis para a padronização e para não esquecer os métodos essenciais, para sempre que for feito algo assim
    public void trocaPneu();
    public void trocaOleo();
    public void abastecer(String combustivel);
}
