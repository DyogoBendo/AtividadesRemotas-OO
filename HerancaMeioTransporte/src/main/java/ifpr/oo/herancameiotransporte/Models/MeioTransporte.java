/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.herancameiotransporte.Models;

/**
 *
 * @author Dyogo
 */
public class MeioTransporte {
    String combustivel, locomocao, marca, modelo, nome;
    float peso;
    int ano, tanque, tanqueMaximo;
    long id;
    boolean isLigado, isMovendo;
    
    public MeioTransporte(){}
    
    public MeioTransporte (String[] mt){
        this.tanque = Integer.parseInt(mt[0]);
        this.isLigado =  Boolean.parseBoolean(mt[1]);
        this.isMovendo = Boolean.parseBoolean(mt[2]);
        this.id =  Long.parseLong(mt[3]);
        this.locomocao = mt[4];
        this.marca = mt[5];
        this.modelo = mt[6];
        this.ano = Integer.parseInt(mt[7]);
        this.combustivel = mt[8];
        this.tanqueMaximo = Integer.parseInt(mt[9]);
        this.peso = Float.parseFloat(mt[10]);
        
        this.nome = this.marca + " - " + this.modelo + " " + this.ano;
    }        

    public String getCombustivel() {
        return combustivel;
    }

    public String getNome() {
        return nome;
    }

    public int getTanqueMaximo() {
        return tanqueMaximo;
    }

    public boolean isLigado() {
        return isLigado;
    }

    public String getLocomocao() {
        return locomocao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPeso() {
        return peso;
    }

    public int getAno() {
        return ano;
    }

    public int getTanque() {
        return tanque;
    }

    public long getId() {
        return id;
    }

    public boolean IsMovendo() {
        return isMovendo;
    }
        

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTanqueMaximo(int tanqueMaximo) {
        this.tanqueMaximo = tanqueMaximo;
    }

    public void setIsLigado(boolean isLigado) {
        this.isLigado = isLigado;
    }
    
    

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setLocomocao(String locomocao) {
        this.locomocao = locomocao;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setTanque(int tanque) {
        this.tanque = tanque;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsMovendo(boolean isMovendo) {
        this.isMovendo = isMovendo;
    }       
        
    public void abastecer(int valorAbastecer) throws Exception{
        if(this.tanque + valorAbastecer > this.tanqueMaximo){
            throw new Exception("O tanque suporta apenas " + this.tanqueMaximo + " de litros.");
        }
        
        if (this.isLigado){
            throw new Exception("O " + this.getLocomocao() + " não pode ser abastecido enquanto está ligado!" );
        }        
        
        if (this.isMovendo){
            throw new Exception("O " + this.getLocomocao() + " não pode ser abastecido enquanto está em movimento!" );
        }
        
        this.tanque += valorAbastecer;
    }
    
    public void ligarDesligar() throws Exception{
        if(this.isMovendo && this.isLigado){
            throw new Exception("O carro deve estar parado para ser desligado!");
        }                
        this.setIsLigado(!isLigado);
    }
    
    public void mover() throws Exception{
        
        if (this.isMovendo){
            throw new Exception ("O " + this.getLocomocao() + " já está em movimento!");
        }
        
        if (!this.isLigado){
            throw new Exception ("O " + this.getLocomocao() + " precisa estar ligado para ser colocado em movimento!");
        }
        
        if (this.tanque == 0){
            throw new Exception ("O " + this.getLocomocao() + " não pode ser colocado em movimento sem combustível!");
        }
        
        this.setIsMovendo(true);        
    }
    
    public void parar() throws Exception{
        if (!this.isMovendo){
            throw new Exception ("O " + this.getLocomocao() + " já está parado!");
        }
        
        this.setIsMovendo(false); 
    }
    
    @Override
    public String toString(){
        String texto =
                this.tanque + ", "
                + this.isLigado + ", "
                + this.isMovendo + ", "
                + this.id + ", "                 
                + this.locomocao + ", "
                + this.marca + ", "
                + this.modelo + ", "
                + this.ano + ", "
                + this.combustivel + ", "
                + this.tanqueMaximo + ", "                
                + this.peso;
                
        return texto;
    }
    
    public String message(){
        String ligado, movendo;
        if (this.isLigado){
            ligado = "Sim";
        } else{
            ligado = "Não";
        }
        
        if (this.isMovendo){
            movendo = "Sim";
        } else{
            movendo = "Não";
        }
        String message = 
                "Id: " + this.id + "\n"
                + "Tipo da Locomoção: " + this.locomocao + "\n"
                + "Nome: " + this.nome + "\n"
                + "Marca: " + this.marca + "\n"
                + "Modelo: " + this.modelo + "\n"
                + "Ano: " + this.ano + "\n"
                + "Tipo de Combustível: " + this.combustivel + "\n"
                + "Quantida máxima aceita no tanque: " + this.tanqueMaximo + " litros \n"
                + "Quantida atual no tanque: " + this.tanque + " litros \n"
                + "Peso: " + this.peso + " Kg \n"
                + "Está ligado? " + ligado + "\n"
                + "Está se movendo? " + movendo + "\n";
        return message;
    }
}
