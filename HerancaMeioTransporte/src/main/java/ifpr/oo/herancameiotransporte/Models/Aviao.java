/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.herancameiotransporte.Models;

import java.util.Date;

/**
 *
 * @author Dyogo
 */
public class Aviao extends MeioTransporte {

    public Aviao(String marca, String modelo, String combustivel, float peso, int ano, int tanqueMaximo) {
        Date d = new Date();
        this.locomocao = "Aviao";
        this.marca = marca;
        this.modelo = modelo;
        this.combustivel = combustivel;
        this.peso = peso;
        this.ano = ano;
        this.tanqueMaximo = tanqueMaximo;
        this.tanque = 0;
        this.id = d.getTime();
        this.nome = this.marca + " - " + this.modelo + " " + this.ano;
    }            
    
}
