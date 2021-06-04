
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Race extends JFrame {
    JFrame frame;
    int t = 0;
    final int LARGURA=1024;
    final int ALTURA= 770;
    final int DELAY = 0;
    final int INTERVAL = 200;
    Timer timer = new Timer();
    
    ArrayList <Square> runners = new ArrayList<>();     
    ArrayList <Square> squares = new ArrayList<>();
    ArrayList <Square> podium = new ArrayList<>();    
    
    
    public Race(){
        this.frame = new JFrame();
    }    
    
    public void showFrame(){
        this.frame.setSize(LARGURA, ALTURA);
        this.frame.setTitle("Corrida de Quadrados!");
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
       this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    
    public void createSquares(){
        Color[] cores = {Color.BLUE,Color.YELLOW,Color.GREEN,Color.RED,
    			Color.BLACK,Color.CYAN,Color.ORANGE,Color.PINK,Color.WHITE,Color.MAGENTA};
        int y = 45;
        for(int i = 0; i < 5; i++){
            Square s = new Square();
            
            s.setMinSpeed(LARGURA);
            s.setMaxSpeed(LARGURA);            
            s.setColor(cores[i]);
            s.setY(y);
            y += 145;                        
            s.setBackground(cores[i]);            
            this.runners.add(s);
        }
    }
    
    public boolean checkFinishedRace(int x, int size){                        
        return x + size >= this.LARGURA;                
    }
    
    public void addPodium(Square s){                    
        this.podium.add(s);
    }
    
    public void updateSquares(){    
        this.t += 1;
        this.runners.forEach((s) ->{               
            s.setSpeed();                                                
            s.setBounds(s.x, s.y, s.LARGURA, s.ALTURA);            
            this.squares.add(s);            
            if(this.checkFinishedRace(s.x, s.LARGURA)) {                                
                this.addPodium(s);
            }            
        });                                
        
        this.podium.forEach((s) -> {
            this.runners.remove(s);            
        });                
            
        this.squares.forEach((s) -> {
            this.frame.add(s);
        });
                
    }        
    
    public void cronometro() {
    timer.scheduleAtFixedRate(new TimerTask() {
    			public void run() {
                                        if(!runners.isEmpty()){
                                            updateSquares();
                                        }    
                                        else{
                                            timer.cancel();
                                            timer.purge();    
                                            Podium podio = new Podium();
                                            podio.showPodium(podium);
                                        }
    				
    			}
    		}, DELAY, INTERVAL);
    }            
    
}
