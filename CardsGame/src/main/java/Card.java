

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public final class Card {
    int valor;
    String nome;
    String naipe;
    String image;
    final String[] TABELA_VALORES = {"J, Q, K, A"};    
    final static String[] NAIPES = {"ouro","espadas", "copa", "pau"};
    
    public Card(int valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;
        this.image = Integer.toString(valor) + naipe;
        this.setNome();
    }
    
    public void setNome(){
        if (this.valor < 11 ){
            this.nome = Integer.toBinaryString(this.valor);
        }else{            
            this.nome = this.TABELA_VALORES[this.valor - 11];
        }        
    }
    
}
