package ifpr.oo.cardsgame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Game {
    ArrayList <Card> deck = new ArrayList <>();
    Player jogadores[] = new Player[2];
    int num_players = 0;           
    Card vira;
    
    public void addPlayer(Player p){
        this.jogadores[num_players] = p;
        this.num_players ++;
    }
    
    public void createDeck(){
        for (int i = 2; i <= 14; i ++){
            for (int j = 0; j < 4; j ++ ){
                Card c = new Card(i, Card.NAIPES[j]);                
                this.deck.add(c);
            }
        }                  
    }
    
    public void distribuirCartas(){                        
        Random r = new Random();
        for(int i = 0; i < 2; i ++){
            ArrayList <Card> d = new ArrayList <>();
            for (int j = 0; j < 5; j++){
                Card c = deck.remove(r.nextInt(deck.size()));                
                d.add(c);
            }
            this.jogadores[i].setDeck(d);
        }        
    }
    
    public int jogarCartas(Card c1, Card c2){                                
        int r = this.determinarVencedor(c1, c2);        
        if (r == 1){
            this.jogadores[1].deck.remove(c2);
            this.jogadores[0].deck.add(c2);
        } else{                        
            this.jogadores[0].deck.remove(c1);
            this.jogadores[1].deck.add(c1);
        }                                                     
        return r;        
    }   
    
    public int determinarVencedor(Card c1, Card c2){
        int c1_naipe = 0;
        int c2_naipe = 0;
        int c1_valor = c1.valor;
        int c2_valor = c2.valor;
        
        for(int i = 0; i < 4; i ++){
            if(Card.NAIPES[i].equals(   c1.naipe)){
                c1_naipe = i;
            }
            if(Card.NAIPES[i].equals(c2.naipe)){
                c2_naipe = i;
            }            
        }
        
        if(c1_valor == Card.getProximo(this.vira.valor)){
            c1_valor += 20;
        }
        
        if(c2_valor == Card.getProximo(this.vira.valor)){
            c2_valor += 20;
        }                        
        
        if (c1_valor > c2_valor){            
            return 1;
        } else if(c1_valor < c2_valor){
            return 2;
        } else{
            if(c1_naipe > c2_naipe){                
                return 1;
            } else{
                return 2;
            }
        }
    }
    
    public void startGame(){   
        this.createDeck();
        this.distribuirCartas();
    }
    
    public void escolheVira(){
        Random r = new Random();
        this.vira = this.deck.remove(r.nextInt(this.deck.size()));
    }

    @Override
    public String toString() {
        return "Game{" + "deck=" + deck + ", jogadores=" + jogadores + ", num_players=" + num_players + '}';
    }
    
    
}
