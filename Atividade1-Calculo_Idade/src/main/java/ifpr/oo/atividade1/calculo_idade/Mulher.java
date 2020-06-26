/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade1.calculo_idade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dyogo
 */
public class Mulher extends Pessoa {

    @Override
    public int[] calculaIdade(Date data) {
        Date data_atual = new Date();
        
        long diferencaMS = (data_atual.getTime() - data.getTime());
        
        long diferencaSegundos = diferencaMS / 1000;
        int segundos = (int) diferencaSegundos % 60;
        
        long diferencaMinutos = diferencaSegundos / 60;
        int minutos = (int) diferencaMinutos % 60;
        
        long diferencaHoras = diferencaMinutos / 60;
        int horas = (int) diferencaHoras % 24;
        
        int diferencaDias = (int) diferencaHoras / 24;
        if (diferencaDias >= 365 * 4){
            int bissexto = diferencaDias / (365 * 4);
            diferencaDias -= bissexto;
        }
        int dias = diferencaDias % 365;
        
        int anos = diferencaDias/ 365;
        this.idade = anos;
        
        int tempo[] = {segundos, minutos, horas, dias};
        
        return tempo;
    }

    public Date perguntarIdade() throws ParseException {
        String resposta = JOptionPane.showInputDialog("Qual seu nome?");
        darNome(resposta);
        String nascimento = JOptionPane.showInputDialog(null, this.nome + ", digite no formato: dia/mes/ano", "Data de Nascimento", JOptionPane.OK_OPTION);
        Date data_nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        return data_nascimento;
    }

    public void mostrarIdade(int[] tempo) {
        String mensagem = "<html><h1>" + this.nome + " sua idadade atual é de " + this.idade + "</h1><br/>" +
                "<h2>Faltam para seu aniversário: " + "<br>" + 
                "<u>Segundos:</u> " + (60 - tempo[0]) + "<br/>" + 
                "<u>Minutos: </u>" + (60 - tempo[1] - 1) + "<br/>" + 
                "<u>Horas:</u> " + (24 - tempo[2] - 1) + "<br/>" + 
                "<u>Dias:</u> " + (365 - tempo[3] - 1) + "<br/>" +
                "</html>"
                ;
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void main(String[] args) throws ParseException {
        Mulher m = new Mulher();

        m.mostrarIdade(m.calculaIdade(m.perguntarIdade()));
    }

}
