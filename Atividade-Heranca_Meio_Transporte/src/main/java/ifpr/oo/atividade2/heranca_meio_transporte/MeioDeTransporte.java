/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade2.heranca_meio_transporte;

/**
 *
 * @author Dyogo
 */
public class MeioDeTransporte {

    String combustível;
    String locomocao;
    String marca;
    String modelo;
    Float peso;
    int ano;
    int tanque = 0;
    boolean ligado = false;
    
    public MeioDeTransporte(String marca, String modelo, float peso, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.ano = ano;
    }
    public MeioDeTransporte(){
    }

    public void abastecer(String combustivel, int litros){
        this.combustível = combustivel;
        this.tanque += litros;
        System.out.println("Tanque preenchido com " + litros + " litros de " + this.combustível);
    }

    public void ligar_desligar(){
        this.ligado = !this.ligado;
        if (ligado) {
            System.out.println("Meio de transporte ligando...");
        } else{
            System.out.println("Meio de transporte desligando...");
        }
    }

    public void mover(){
        if(this.ligado){
            if(this.tanque >= 10){
                System.out.println("Meio de transporte em movimento...");
                this.tanque -= 10;
            }
            else{
                System.out.println("Tanque vazio ou insuficiente (menor que 10 litros). Reabasteça o meio de transporte");
            }
        }
        else{
            System.out.println("O meio de transporte precisa estar ligado para poder se locomover");
        }
    }
    
    public void mostrar_ficha(){
        System.out.println("Marca = " + this.marca +"\n" +
"        Modelo = "+ this.modelo +"\n" +
"        Peso = "+ this.peso +"\n" +
"        Ano = " + this.ano + "\n" + 
"        Tanque = " + this.tanque + "\n" +
"        Ligado = " + this.ligado);
    }
}
