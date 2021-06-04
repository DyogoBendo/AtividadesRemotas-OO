
import java.awt.Color;
import java.util.Random;
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
public class Square extends JPanel {
    int minSpeed, maxSpeed, speed;
    int x, y;    

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    final int LARGURA = 100;
    final int ALTURA = 100;    
    Color color;    
    Random r = new Random();
    
    public Square(){
        super();
        this.x = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed() {             
        int s = r.nextInt(maxSpeed - minSpeed) + minSpeed;        
        this.speed = s;
        this.updateX();
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int largura) {
        int v1 = (int) largura / 48;
        int v2 = (int) largura / 60;
        this.minSpeed = r.nextInt(v1 - v2) + v2;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int largura) {
        int v1 = (int) largura / 32;
        int v2 = (int) largura / 40;
        this.maxSpeed = r.nextInt(v1 - v2) + v2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }            

    public void updateX(){
        this.x += this.speed;
    }
    
}
