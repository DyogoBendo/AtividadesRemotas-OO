/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade1.calculo_idade;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author Dyogo
 */
public abstract class Pessoa {

    int idade;
    String nome;
    double peso, altura;

    public int[] calculaIdade(Date data){
        Date data_atual = new Date();
        
        long diferencaMS = (data_atual.getTime() - data.getTime());
        
        long diferencaSegundos = diferencaMS / 1000;
        int segundos = (int) diferencaSegundos % 60;
        
        long diferencaMinutos = diferencaSegundos / 60;
        int minutos = (int) diferencaMinutos % 60;
        
        long diferencaHoras = diferencaMinutos / 60;
        int horas = (int) diferencaHoras % 24;
        
        int diferencaDias = (int) diferencaHoras / 24;
        if (diferencaDias >= 365 * 4){
            int bissexto = diferencaDias / (365 * 4);
            diferencaDias -= bissexto;
        }
        int dias = diferencaDias % 365;
        
        int anos = diferencaDias/ 365;
        definirIdade(anos);
        
        int tempo[] = {segundos, minutos, horas, dias};
        
        return tempo;
    }

    public void darNome(String nome) { // método com implementação
        this.nome = nome;
    }
    
    public abstract void definirIdade(int nascimento);
    
    public abstract Color defineCorTexto();
    public abstract Color defineCorFundo();
}
