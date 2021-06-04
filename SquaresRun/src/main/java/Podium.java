
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Podium extends JFrame {
    JFrame frame;    
    final int LARGURA=1024;
    final int ALTURA= 770;

    public Podium(){
        this.frame = new JFrame();        
    }    
    
    public void showFrame(){
        this.frame.setSize(LARGURA, ALTURA);
        this.frame.setTitle("Pódio!");
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
        
    public void showPodium(ArrayList<Square> podium){                                                          
        int x = 50;
        int y = 45;
        int k = 0;
        for(Square s : podium){                 
            k ++;            
            JLabel position = new JLabel(Integer.toString(k));           
            position.setBounds(x, y, 50, 50);
            s.x = x;
            s.y = y;            
            y += 145;
            this.frame.add(s);
            this.frame.add(position);            
        }                            
        this.showFrame();   
    }    
}
