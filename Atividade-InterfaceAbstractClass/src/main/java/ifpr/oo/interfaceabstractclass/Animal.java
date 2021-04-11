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
public abstract class Animal {
    int idade;
    String nome, sexo;
    double peso, altura;
    
    
    public int calcularIdadeHumana(int idade_humana){  // essa idade passada é a idade relativa. Por exemplo, um cachorro de 1 ano de idade teria 15 anos se fosse humano
        return (int) idade_humana * idade;
    }
    
    public abstract void darNome(String nome);
    public abstract boolean isAlto();
}
