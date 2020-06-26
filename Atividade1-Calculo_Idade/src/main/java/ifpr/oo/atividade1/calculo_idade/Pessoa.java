/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade1.calculo_idade;

import java.util.Date;

/**
 *
 * @author Dyogo
 */
public abstract class Pessoa {

    int idade;
    String nome;
    double peso, altura;

    public abstract int[] calculaIdade(Date data); // declaração de método abstrato

    public void darNome(String nome) { // método com implementação
        this.nome = nome;
    }
}
