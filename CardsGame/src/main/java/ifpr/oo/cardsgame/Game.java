package ifpr.oo.cardsgame;
import java.util.ArrayList;
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
    Player computador;
    Player jogador;    
    Card vira;        
    
    public Game(){
        this.computador = new Player("Computador");
    }
    
    public void createDeck(){
        for (int i = 2; i <= 14; i ++){
            for (int j = 0; j < 4; j ++ ){
                Card c = new Card(i, Card.NAIPES[j]);                
                this.deck.add(c);
            }
        }                  
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public Player getComputador() {
        return computador;
    }

    public void setComputador(Player computador) {
        this.computador = computador;
    }

    public Player getJogador() {
        return jogador;
    }

    public void setJogador(Player jogador) {
        this.jogador = jogador;
    }

    public Card getVira() {
        return vira;
    }

    public void setVira(Card vira) {
        this.vira = vira;
    }
    
    public void distribuirCartas(){                        
        Random r = new Random();        
        ArrayList <Card> d = new ArrayList <>();
        ArrayList <Card> e = new ArrayList <>();
        for (int j = 0; j < 5; j++){
            Card c1 = deck.remove(r.nextInt(deck.size()));      
            Card c2 = deck.remove(r.nextInt(deck.size()));
            d.add(c1);            
            e.add(c2);
        }                            
        this.computador.setDeck(d);
        this.jogador.setDeck(e);               
    }
    
    public int jogarCartas(Card c1, Card c2){                                
        int r = this.determinarVencedor(c1, c2);        
        if (r == 1){  // 1 indica que o computador venceu, e 2 que o jogador venceu
            this.jogador.deck.remove(c2);
            this.computador.deck.add(c2);
            System.out.println(c2.nome);
        } else{                        
            this.computador.deck.remove(c1);
            this.jogador.deck.add(c1);
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
        if(c1_valor == Card.getValorProximo(this.vira.valor)){
            c1_valor += 20;
        }
        
        if(c2_valor == Card.getValorProximo(this.vira.valor)){
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
}
