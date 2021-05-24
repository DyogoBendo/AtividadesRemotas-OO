
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
    Player jogadores[] = new Player[2];
    int num_players = 0;
    
    public void addPlayer(Player p){
        this.jogadores[num_players] = p;
        this.num_players ++;
    }
    
    public void createDeck(){
        for (int i = 1; i <= 14; i ++){
            for (int j = 0; j < 4; j ++ ){
                Card c = new Card(i, Card.NAIPES[j]);                
                deck.add(c);
            }
        }
    }
    
    public void distribuirCartas(){                
        int num_cartas = this.deck.size() / this.num_players;        
        Random r = new Random();
        for(int i = 0; i < 2; i ++){
            ArrayList <Card> d = new ArrayList <>();
            for (int j = 0; j < num_cartas; j++){
                Card c = deck.remove(r.nextInt(deck.size()));                
                d.add(c);
            }
            this.jogadores[i].setDeck(d);
        }
    }
    
    public void jogarCartas(int play){
        Player computador = this.jogadores[0];
        Player jogador = this.jogadores[1];
        
        Card c1 = computador.deck.get(computador.deck.size());
        Card c2;
        if(play == -1){
            c2 = jogador.deck.get(jogador.deck.size());
        }else{
            c2 = jogador.deck.get(play);
        }        
        
        int r = this.determinarVencedor(c1, c2);
        
        if (r == 1){
            computador.deck.add(c2);
            jogador.deck.remove(c2);
        } else{
            jogador.deck.add(c1);
            computador.deck.remove(c1);
        }
        this.jogadores[0] = computador;
        this.jogadores[1] = jogador;        
        
    }   
    
    public int determinarVencedor(Card c1, Card c2){
        int c1_naipe = 0;
        int c2_naipe = 0;
        
        for(int i = 0; i < 4; i ++){
            if(Card.NAIPES[i].equals(c1.naipe)){
                c1_naipe = i;
            }
            if(Card.NAIPES[i].equals(c2.naipe)){
                c2_naipe = i;
            }            
        }
        if (c1_naipe > c2_naipe){            
            return 1;
        } else if(c1_naipe < c2_naipe){
            return 2;
        } else{
            if(c1.valor > c2.valor){                
                return 1;
            } else{
                return 2;
            }
        }
    }
    
    public void startGame(){        
        this.distribuirCartas();
    }
    
}
