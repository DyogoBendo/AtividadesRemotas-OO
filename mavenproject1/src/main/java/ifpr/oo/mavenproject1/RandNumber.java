/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.mavenproject1;

import java.util.Arrays;
import static java.util.Arrays.sort;
import java.util.Random;

/**
 *
 * @author Dyogo
 */
public class RandNumber{
    final int TAMANHO = 10;
    int numbers[] = new int[TAMANHO];
    int tamanho_atual = 0;    
    
    public int inserirNumero(int n){        
        this.numbers[this.tamanho_atual] = n;
        this.tamanho_atual ++;        
        System.out.println(Arrays.toString(this.numbers));
        return this.tamanho_atual;
    }
    
    public int inserirMultiplosNumerosAleatorios(int n, int b, int e){
        int li  = 0;  // last index
        for(int i = 0; i < n; i ++){
            Random r = new Random();
            li = this.inserirNumero(r.nextInt(e - b) + b);
        }
        this.sort_array();
        return li;
    }
    
    public boolean search(int v, int i, int j){                
        
        if (j < i || i >= this.TAMANHO){
            return false;
        }
        
        int m = (i + j) / 2;        
        if (this.numbers[m] == v){
            return true;
        }                
        else if (v < this.numbers[m]){            
            return this.search(v, i, m - 1);
        }                
        else{
            return this.search(v, m + 1, j);
        }
    }
    
    
    public void sort_array(){
        sort(this.numbers);
    }
    
}
