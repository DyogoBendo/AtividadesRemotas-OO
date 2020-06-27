/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade1.calculo_idade;

import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Dyogo
 */
public class Main {
    
    //Mulher

    public static Date perguntarIdade(Mulher m) throws ParseException {
        String resposta = JOptionPane.showInputDialog("Qual seu nome?");
        m.darNome(resposta);
        String nascimento = JOptionPane.showInputDialog(null, m.nome + ", digite no formato: dia/mes/ano", "Data de Nascimento", JOptionPane.OK_OPTION);
        Date data_nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        return data_nascimento;
    }
    
    //Homem

    public static Date perguntarIdade(Homem h) throws ParseException {
        String resposta = JOptionPane.showInputDialog("Qual seu nome?");
        h.darNome(resposta);
        String nascimento = JOptionPane.showInputDialog(null, h.nome + ", digite no formato: dia/mes/ano", "Data de Nascimento", JOptionPane.OK_OPTION);
        Date data_nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        return data_nascimento;
    }

    //Mulher
    public static void mostrarIdade(int[] tempo, Mulher m) {
        String mensagem = "<html><h1>" + m.nome + " sua idadade atual é de: " + m.idade + "</h1><br/>"
                + "<h2>Faltam para seu aniversário: " + "<br>"
                + "<u>Segundos:</u> " + (60 - tempo[0]) + "<br/>"
                + "<u>Minutos: </u>" + (60 - tempo[1] - 1) + "<br/>"
                + "<u>Horas:</u> " + (24 - tempo[2] - 1) + "<br/>"
                + "<u>Dias:</u> " + (365 - tempo[3] - 1) + "<br/>"
                + "</html>";
        
        
        JLabel texto = new JLabel(mensagem);
        texto.setFont(new Font("Times New Roman", 1, 20));
        texto.setForeground(m.defineCorTexto());
        
        JScrollPane scroll = new JScrollPane(texto);
        scroll.getViewport().setBackground(m.defineCorFundo());
        scroll.setPreferredSize(new Dimension(500, 500));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JOptionPane.showMessageDialog(null, scroll, "Idade", JOptionPane.CLOSED_OPTION);
    }
    
    // Homem

    public static void mostrarIdade(int[] tempo, Homem h) {
         String mensagem = "<html><h1>" + h.nome + " sua idadade atual é de: " + h.idade + "</h1><br/>"
                + "<h2>Faltam para seu aniversário: " + "<br>"
                + "<u>Segundos:</u> " + (60 - tempo[0]) + "<br/>"
                + "<u>Minutos: </u>" + (60 - tempo[1] - 1) + "<br/>"
                + "<u>Horas:</u> " + (24 - tempo[2] - 1) + "<br/>"
                + "<u>Dias:</u> " + (365 - tempo[3] - 1) + "<br/>"
                + "</html>";
         
         
        JLabel texto = new JLabel(mensagem);
        texto.setFont(new Font("Times New Roman", 1, 20));
        texto.setForeground(h.defineCorTexto());
        
        
        JScrollPane scroll = new JScrollPane(texto);
        scroll.getViewport().setBackground(h.defineCorFundo());
        scroll.setPreferredSize(new Dimension(500, 500));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JOptionPane.showMessageDialog(null, scroll, "Idade", JOptionPane.CLOSED_OPTION);
    }
    
    

    public static void main(String[] args) throws ParseException {
        int resposta;
        String[] sexo = {"Mulher", "Homem"};
        
        resposta = JOptionPane.showOptionDialog(null, "Qual o seu sexo?", "Inicio", 0, JOptionPane.QUESTION_MESSAGE, null, sexo, sexo[0]);
        
        switch (resposta){
            case 0:
                Mulher m = new Mulher();
                mostrarIdade(m.calculaIdade(perguntarIdade(m)), m);
                break;
            case 1:
                Homem h = new Homem();
                mostrarIdade(h.calculaIdade(perguntarIdade(h)), h);
        }
    }
}
