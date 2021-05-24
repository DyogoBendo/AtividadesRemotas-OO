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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;    
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Screen extends JFrame {
    CardLayout cl = new CardLayout();
    JPanel cards;    
    GridBagConstraints constraints;
    Player p;
    Game g;
    Random r = new Random();
    
    public JPanel askName(){                
        JPanel painel = new JPanel(new GridBagLayout());                
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        JLabel labelNome = new JLabel("Insira seu nome: ");    
        JTextField nome = new JTextField(20);
        
        String iconPath = "src/main/java/images/start.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JButton button = new JButton(icon);
        
        button.addActionListener((var evt) -> {            
            p = new Player(nome.getText());      
            g.addPlayer(p);             
            this.g.startGame();
                JPanel displayCards = null;
            try {
                displayCards = this.displayCards();
            } catch (IOException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
                this.cards.add("displayCards", displayCards);      
                this.cl.show(this.cards, "displayCards");
        });                
                                 
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        painel.add(labelNome, constraints);
 
        constraints.gridx = 1;
        painel.add(nome, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        
        constraints.anchor = GridBagConstraints.CENTER;
        painel.add(button, constraints);
                 
         
        // set border for the panel
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
         
        // add the panel to this frame
        
        return painel;
        
        // String nome = JOptionPane.showInputDialog(labelNome, painel,"Teste" , HEIGHT);        
        
    }
    
    public JPanel displayCards() throws IOException{        
        JPanel painel = new JPanel(new GridBagLayout());   
        
        if(p.deck.isEmpty()){
            this.setSize(new Dimension(300, 300));
            JLabel derrota = new JLabel("Você perdeu :(");
            JButton buttonExit = new JButton("Sair do jogo");                        
            
            buttonExit.addActionListener((ActionEvent evt) -> {
                this.dispose();
            });          
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.gridx = 0;
            constraints.gridy = 0;            
            painel.add(derrota, constraints);
            constraints.gridx = 0;
            constraints.gridy = 1;            
            painel.add(buttonExit, constraints);
            
        } else if(this.g.jogadores[0].deck.isEmpty()){
            this.setSize(new Dimension(300, 300));
            JLabel vitoria = new JLabel("Você ganhou :)");
            JButton buttonExit = new JButton("Sair do jogo");
            
            buttonExit.addActionListener((ActionEvent evt) -> {
                this.dispose();
            });          
            
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.gridx = 0;
            constraints.gridy = 0;            
            painel.add(vitoria, constraints);
            constraints.gridx = 0;
            constraints.gridy = 1;            
            painel.add(buttonExit, constraints);
        }else{               
            this.setSize(new Dimension(600, 500));
            this.g.escolheVira();            
            constraints.gridx = 3;
            constraints.gridy = 0;
            String iconPathVira = "src/main/java/images/"+ this.g.vira.image + ".png";                
            BufferedImage myViraPicture = ImageIO.read(new File(iconPathVira));        
            JLabel picVira = new JLabel(new ImageIcon(myViraPicture));
            painel.add(picVira, constraints);
            
            constraints.gridx = 3;
            constraints.weighty = 2 ;
            constraints.gridy = 3;            
            String valorVira = Card.getNomeProximo(this.g.vira.valor);
            JLabel vira = new JLabel ("Vira: " + valorVira + " é o mais forte da rodada");
            painel.add(vira, constraints);                                            
            int x = 0;
            int y = 4;        
            constraints.weightx = 2;
            for (Card card : p.deck) {                     
                String iconPath = "src/main/java/images/"+ card.image + ".png";                
                ImageIcon icon = new ImageIcon(iconPath);
                JButton button = new JButton(icon);                        

                button.addActionListener((ActionEvent evt) -> {      
                    int position = r.nextInt(this.g.jogadores[0].deck.size());                            
                    Card computadorCard = this.g.jogadores[0].deck.get(position);
                    int w = this.g.jogarCartas(computadorCard, card);
                    try {
                        this.cards.removeAll();
                        JPanel compareCards = this.compareCards(computadorCard, card, w);                        
                        this.cards.add("compareCards", compareCards);      
                        this.cl.show(this.cards, "compareCards");                        
                    } catch (IOException ex) {
                        Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.invalidate();
                    this.validate();
                    this.repaint();                    
                });
                constraints.gridx = x;
                constraints.gridy = y;                                
                if (x < 10){
                    x += 2;                    
                } else{
                    x = 0;
                    y += 1;
                }                
                painel.add(button, constraints);
              } 
        }                 
        return painel;
    }
    
    public JPanel compareCards(Card computerCard, Card playerCard, int winner) throws IOException{
        JPanel painel = new JPanel(new GridBagLayout());                                                
        this.setSize(new Dimension(600, 400));
        constraints.gridx = 0;
        constraints.gridy = 0;                                                                                
        
        String iconPathComputer = "src/main/java/images/"+ computerCard.image + ".png";                
        BufferedImage myComputerPicture = ImageIO.read(new File(iconPathComputer));        
        JLabel picComputer = new JLabel(new ImageIcon(myComputerPicture));        
        painel.add(picComputer, constraints);
        
        constraints.gridx = 2;
        String iconPathVira = "src/main/java/images/"+ this.g.vira.image + ".png";                
        BufferedImage myViraPicture = ImageIO.read(new File(iconPathVira));        
        JLabel picVira = new JLabel(new ImageIcon(myViraPicture));
        painel.add(picVira, constraints);
        
        constraints.gridx = 4;
        String iconPathPlayer = "src/main/java/images/"+ playerCard.image + ".png";                
        BufferedImage myPlayerPicture = ImageIO.read(new File(iconPathPlayer));        
        JLabel picPlayer = new JLabel(new ImageIcon(myPlayerPicture));
        painel.add(picPlayer, constraints);
                
        
        constraints.gridx = 0;
        constraints.gridy = 1;  
        
        JLabel p1 = new JLabel ("Computador");
        painel.add(p1, constraints);                                                        
        
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        
        String valorVira = Card.getNomeProximo(this.g.vira.valor);
        JLabel vira = new JLabel ("Vira: " + valorVira + " é o mais forte da rodada");
        painel.add(vira, constraints);                
        
        constraints.gridx = 4;
        constraints.gridy = 1;
        
        JLabel p2 = new JLabel (p.nome);
        painel.add(p2, constraints);                                                        
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        
        String txtWinner;
        
        if (winner == 1){
            txtWinner = "Você perdeu :(";
        } else{
            txtWinner = "Você venceu :)";
        }
        
        JLabel vencedor = new JLabel (txtWinner);
        painel.add(vencedor, constraints);                                                        
        
        constraints.gridx = 4;
        JButton button = new JButton("Jogar novamente");
        button.addActionListener((ActionEvent evt) -> { 
                this.invalidate();
                this.validate();
                this.repaint();
                this.cards.removeAll();
                JPanel displayCards = null;
            try {
                displayCards = this.displayCards();
            } catch (IOException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
                this.cards.add("displayCards", displayCards);      
                this.cl.show(this.cards, "displayCards");                                
        });
        painel.add(button, constraints);
        return painel;
    }
    
    public void createPanels(){                
        JPanel askNome =  this.askName();                        
        this.cards.add("askNome", askNome);
        this.cl.show(cards, "askNome");                      
        
        add(cards);
        pack();
        setLocationRelativeTo(null);
    }
    
    public Screen(){    
        super("Card Game");           
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        cards = new JPanel(cl);
        constraints = new GridBagConstraints();
        Player computador = new Player("Computador");
        g = new Game();
        g.addPlayer(computador);
        this.createPanels();
    }

}
