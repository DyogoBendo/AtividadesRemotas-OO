/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.mavenproject1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dyogo
 */
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        RandNumber rn = new RandNumber();
        
        rn.inserirMultiplosNumerosAleatorios(10, 0, 100);
        System.out.println(Arrays.toString(rn.numbers));
        int e;
        do{            
            System.out.println("Insira um número entre 0 e 100 e verifique se ele está no array, insira -1 para sair");
            e = t.nextInt();            
            System.out.println(rn.search(e, 0, 10));
        } while (e >= 0);
        
    }
}
