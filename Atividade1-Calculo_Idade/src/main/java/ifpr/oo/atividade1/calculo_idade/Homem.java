/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade1.calculo_idade;

import java.awt.Color;

/**
 *
 * @author Dyogo
 */
public class Homem extends Pessoa {
    @Override
    public void definirIdade(int nascimento) {
        this.idade = nascimento;
    }

    @Override
    public Color defineCorTexto() {
        return Color.LIGHT_GRAY;
    }   

    @Override
    public Color defineCorFundo() {
        return Color.BLUE;
    }
    
}
