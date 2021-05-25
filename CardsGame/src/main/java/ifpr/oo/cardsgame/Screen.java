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
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Screen extends JFrame {
    CardLayout cl = new CardLayout();
    JPanel cards;    
    GridBagConstraints constraints = new GridBagConstraints();
    Player p;
    Game g = new Game();
    Random r = new Random();
    JPanel displayCards, compareCards, askName;
    JButton exit;
    JLabel textoVitoria, textoDerrota;
    
    public JPanel askName(){                
        JPanel painel = new JPanel(new GridBagLayout());                     
        JLabel labelNome = new JLabel("Insira seu nome: ");    
        JTextField nome = new JTextField(20);
        
        String iconPath = "src/main/java/images/start.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JButton button = new JButton(icon);
        
        button.addActionListener((var evt) -> {            
            this.p = new Player(nome.getText());      
            this.g.setJogador(p);             
            this.g.startGame();
            this.displayCards = null;            
            try {
                this.displayCards = this.displayCards();
                this.cards.add("displayCards", this.displayCards);      
                this.cl.show(this.cards, "displayCards");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });                
                                         
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;     
        painel.add(labelNome, this.constraints);
 
        this.constraints.gridx = 1;
        painel.add(nome, this.constraints);
        
        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.constraints.gridwidth = 2;        
        this.constraints.anchor = GridBagConstraints.CENTER;
        painel.add(button, this.constraints);
                                  
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));                 
        
        return painel;                
        
    }
    
    public JPanel displayCards() throws IOException{        
        JPanel painel = new JPanel(new GridBagLayout());           
        this.setSize(new Dimension(300, 300));
        if(p.deck.isEmpty()){                         
            this.constraints.anchor = GridBagConstraints.CENTER;
            this.constraints.gridx = 0;
            this.constraints.gridy = 0;            
            painel.add(this.textoDerrota, this.constraints);
            
            this.constraints.gridx = 0;
            this.constraints.gridy = 1;            
            painel.add(this.exit, this.constraints);
            
        } else if(this.g.computador.deck.isEmpty()){                       
            this.constraints.anchor = GridBagConstraints.CENTER;
            this.constraints.gridx = 0;
            this.constraints.gridy = 0;            
            painel.add(this.textoVitoria, this.constraints);
            
            this.constraints.gridx = 0;
            this.constraints.gridy = 1;            
            painel.add(this.exit, this.constraints);
        }else{               
            this.setSize(new Dimension(600, 500));
            
            this.g.escolheVira();                        
            this.constraints.gridx = 3;
            this.constraints.gridy = 0;
            String iconPathVira = "src/main/java/images/"+ this.g.vira.image + ".png";                
            BufferedImage myViraPicture = ImageIO.read(new File(iconPathVira));        
            JLabel picVira = new JLabel(new ImageIcon(myViraPicture));
            painel.add(picVira, constraints);
            
            this.constraints.gridx = 3;
            this.constraints.weighty = 2 ;
            this.constraints.gridy = 3;            
            String valorVira = Card.getNomeProximo(this.g.vira.valor);
            JLabel vira = new JLabel ("Vira: " + valorVira + " é o mais forte da rodada");
            painel.add(vira, this.constraints);                                            
            
            int x = 0;
            int y = 4;        
            this.constraints.weightx = 2;
            for (Card card : this.p.deck) {                     
                String iconPath = "src/main/java/images/"+ card.image + ".png";                
                ImageIcon icon = new ImageIcon(iconPath);
                JButton button = new JButton(icon);                        

                button.addActionListener((ActionEvent evt) -> {      
                    int position = r.nextInt(this.g.computador.deck.size());                            
                    Card computadorCard = this.g.computador.deck.get(position);
                    int w = this.g.jogarCartas(computadorCard, card);
                    try {
                        this.cards.removeAll();
                        this.compareCards = this.compareCards(computadorCard, card, w);                        
                        this.cards.add("compareCards", this.compareCards);      
                        this.cl.show(this.cards, "compareCards");                        
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    this.invalidate();
                    this.validate();
                    this.repaint();                    
                });
                this.constraints.gridx = x;
                this.constraints.gridy = y;                                
                if (x < 10){
                    x += 2;                    
                } else{
                    x = 0;
                    y += 1;
                }                
                painel.add(button, this.constraints);
              } 
        }                 
        return painel;
    }
    
    public JPanel compareCards(Card computerCard, Card playerCard, int winner) throws IOException{
        JPanel painel = new JPanel(new GridBagLayout());                                                
        this.setSize(new Dimension(600, 400));
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;                                                                                
        
        String iconPathComputer = "src/main/java/images/"+ computerCard.image + ".png";                
        BufferedImage myComputerPicture = ImageIO.read(new File(iconPathComputer));        
        JLabel picComputer = new JLabel(new ImageIcon(myComputerPicture));        
        painel.add(picComputer, this.constraints);
        
        this.constraints.gridx = 2;
        String iconPathVira = "src/main/java/images/"+ this.g.vira.image + ".png";                
        BufferedImage myViraPicture = ImageIO.read(new File(iconPathVira));        
        JLabel picVira = new JLabel(new ImageIcon(myViraPicture));
        painel.add(picVira, this.constraints);
        
        this.constraints.gridx = 4;
        String iconPathPlayer = "src/main/java/images/"+ playerCard.image + ".png";                
        BufferedImage myPlayerPicture = ImageIO.read(new File(iconPathPlayer));        
        JLabel picPlayer = new JLabel(new ImageIcon(myPlayerPicture));
        painel.add(picPlayer, this.constraints);
                
        
        this.constraints.gridx = 0;
        this.constraints.gridy = 1;  
        
        JLabel p1 = new JLabel ("Computador");
        painel.add(p1, constraints);                                                        
        
        
        this.constraints.gridx = 2;
        this.constraints.gridy = 1;
        
        String valorVira = Card.getNomeProximo(this.g.vira.valor);
        JLabel vira = new JLabel ("Vira: " + valorVira + " é o mais forte da rodada");
        painel.add(vira, this.constraints);                
        
        this.constraints.gridx = 4;
        this.constraints.gridy = 1;
        
        JLabel p2 = new JLabel (this.p.nome);
        painel.add(p2, this.constraints);                                                        
        
        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        
        String txtWinner;
        
        if (winner == 1){
            painel.add(this.textoDerrota, this.constraints);                                                        
        } else{
            painel.add(this.textoVitoria, this.constraints);
        }                        
        
        this.constraints.gridx = 4;
        JButton button = new JButton("Jogar novamente");
        button.addActionListener((var evt) -> { 
                this.invalidate();
                this.validate();
                this.repaint();
                this.cards.removeAll();
                this.displayCards = null;
            try {
                this.displayCards = this.displayCards();
            } catch (IOException ex) {
                System.out.println(ex);                
            }
                this.cards.add("displayCards", displayCards);      
                this.cl.show(this.cards, "displayCards");                                
        });
        painel.add(button, this.constraints);
        return painel;
    }
    
    public void createPanels(){       
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);                
        
        this.askName =  this.askName();                        
        this.cards.add("askNome", this.askName);
        this.cl.show(cards, "askNome");                      
        
        this.add(cards);
        this.pack();
        setLocationRelativeTo(null);
    }
    
    public void initialzeComponents(){        
        // Botão de saída
        this.exit = new JButton("Sair do jogo");                                    
        this.exit.addActionListener((var evt) -> {
                this.dispose();
        });     
        
        //Texto de vitória e derrota
        this.textoVitoria = new JLabel("Você venceu :)");
        this.textoDerrota = new JLabel("Você perdeu :(");
    }
    
    public Screen(){    
        super("Card Game");           
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        this.cards = new JPanel(cl);                                
        this.initialzeComponents();
        this.createPanels();
    }
}
