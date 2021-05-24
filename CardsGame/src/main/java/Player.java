
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Player {
    String nome;
    ArrayList <Card> deck;
    
    
    public Player(String nome){
        this.nome = nome;
    }    
    
    public Player(String nome, ArrayList<Card> deck){
        this.nome = nome;
        this.deck = deck;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
        
}
