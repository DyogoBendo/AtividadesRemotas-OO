package ifpr.oo.cardsgame;



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
    final static String[] TABELA_VALORES = {"J", "Q", "K", "A"};    
    final static String[] NAIPES = {"ouro","espada", "copa", "pau"};    
    
    public Card(int valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;        
        this.setNome();
        this.image = this.nome + naipe;
    }
    
    public void setNome(){
        if (this.valor < 11 ){
            this.nome = Integer.toString(this.valor);
        }else{            
            int p = this.valor - 11;            
            this.nome = TABELA_VALORES[p];
        }        
    }
    public static String getNomeProximo(int valor){
        if (valor < 10){            
            return Integer.toString(valor + 1);                            
        }
        else if(valor == 14){
            return "2";
        }        
        else{            
            int p = valor - 10;             
            return TABELA_VALORES[p];
        }        
    }
    
    public static int getValorProximo(int valor){
        if(valor == 14){
            return 2;
        } else{
            return valor + 1;
        }
    }   
    
}
