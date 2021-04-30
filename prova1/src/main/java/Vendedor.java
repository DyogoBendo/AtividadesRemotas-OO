/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Vendedor extends Funcionario{
    private EquipeVenda equipe;

    public EquipeVenda getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeVenda equipe) {
        this.equipe = equipe;
    }
        
      
    @Override
    public float getSalario() {
        return 2000f;
    }        

    @Override
    public String toString() {
        String txt = "Vendedor: \n\n"
                + "Nome: " + this.getNome() + "\n"
                + "Data de Nascimento: " + this.getNascimento()+ "\n"
                + "CPF: " + this.getCpf() + "\n"
                + "Endereço: " + this.getEndereco()+ "\n"
                + "Salário: " + this.getSalario() + "\n"
                + "Equipe: " + this.getEquipe() + "\n";
        return txt;
    }
}
