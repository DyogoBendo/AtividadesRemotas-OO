/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Gerente extends Funcionario{
    public float getSalario(){
        return 9000f;
    }
    
    @Override
    public String toString() {
        String txt = "Gerente \n\n"
                + "Nome: " + this.getNome() + "\n"
                + "Data de Nascimento: " + this.getNascimento()+ "\n"
                + "CPF: " + this.getCpf() + "\n"
                + "Endereço: " + this.getEndereco()+ "\n"
                + "Salário: " + this.getSalario() + "\n";                
        return txt;
    }
}
