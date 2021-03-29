/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.herancameiotransporte.Views;
import ifpr.oo.herancameiotransporte.DAO.MeioTransporteDAO;
import ifpr.oo.herancameiotransporte.Models.Automovel;
import ifpr.oo.herancameiotransporte.Models.Aviao;
import ifpr.oo.herancameiotransporte.Models.Barco;
import ifpr.oo.herancameiotransporte.Models.MeioTransporte;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dyogo
 */
public final class Telas {       
    public Telas() throws IOException{
        this.mostrarTelaInicial();
    }
    
    public void mostrarTelaInicial() throws IOException{
        String [] escolha_opt = {"Adicionar novo Meio de Transporte", "Ver meios de transporte existentes", "Sair"};
        
        int optMenu = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, escolha_opt, escolha_opt[0]);
        
        switch (optMenu){
            case 0 -> this.adicionarMeioTransporte();
            case 1 -> this.listarMeioTransporte();
            case 2 -> System.exit(0);
        }                        
        
    }
    
    public void adicionarMeioTransporte() throws IOException{
        MeioTransporte mt; 
        String [] escolha_opt = {"Avião", "Automóvel", "Barco","Voltar a Tela inicial", "Sair"};
        
        int optMenu = JOptionPane.showOptionDialog(null, "Qual tipo de meio de transporte deseja adicionar?", "Criação de Meio de Transporte", 0, JOptionPane.QUESTION_MESSAGE, null, escolha_opt, escolha_opt[0]);
        
        switch (optMenu){            
            case 3 -> this.mostrarTelaInicial();
            case 4 -> System.exit(0);
        }
        
        String marca = JOptionPane.showInputDialog(null, "Digite a marca");
        String modelo = JOptionPane.showInputDialog(null, "Digite o modelo");
        String combustivel = JOptionPane.showInputDialog(null, "Digite o tipo de combustível");
        float peso =Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o peso"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano"));
        int tanque = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tamanho do tanque"));
        
        switch (optMenu) {
            case 0 ->                 {
                     mt = new Aviao(marca, modelo, combustivel, peso, ano, tanque);
                }
            case 1 ->                 {
                     mt = new Automovel(marca, modelo, combustivel, peso, ano, tanque);
                }
            default -> {
                 mt = new Barco(marca, modelo, combustivel, peso, ano, tanque);
            }
        }        
        MeioTransporteDAO.inserir(mt);
        
        this.visualizarMeioTransporte(mt);
    }
    
    public void visualizarMeioTransporte(MeioTransporte mt) throws IOException{
        String [] escolha_opt = {"Abastecer", "Ligar/Desligar", "Mover", "Parar", "Visualizar Informações", "Retornar a tela inicial", "Sair"};
        int optMenu = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, escolha_opt, escolha_opt[0]);
        switch (optMenu){
            case 0 -> this.abastecerMeioTransporte(mt);
            case 1 -> this.ligarDesligarMeioTransporte(mt);
            case 2 -> this.moverMeioTransporte(mt);
            case 3 -> this.pararMeioTransporte(mt);
            case 4 -> this.visualizarDadosMeioTransporte(mt);
            case 5 -> this.mostrarTelaInicial();
            case 6 -> System.exit(0);
        }
        
    }
    
    
    public void abastecerMeioTransporte(MeioTransporte mt) throws IOException{
        int valorAbastecer = Integer.parseInt(JOptionPane.showInputDialog(null, "Com quantos litros de " + mt.getCombustivel() + " deseja encher o tanque de seu " + mt.getLocomocao() + "?"));
        try {            
            mt.abastecer(valorAbastecer);
            String message = mt.getLocomocao() + " abastecido com " + valorAbastecer + " litros de " + mt.getCombustivel();
            JOptionPane.showMessageDialog(null, message, "Abastecimento", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        String tanqueAtual = Integer.toString(mt.getTanque());
        MeioTransporteDAO.substituirEstado(tanqueAtual, 0, mt);
        
        this.visualizarMeioTransporte(mt);
    }
 
   public void ligarDesligarMeioTransporte(MeioTransporte mt) throws IOException{
       try {
           mt.ligarDesligar();
           String estado;
           if (mt.isLigado()){
               estado = "ligado";
           } else{
               estado = "desligado";
           }
           String message = "O " + mt.getLocomocao() + " foi " + estado + " com sucesso!";
           JOptionPane.showMessageDialog(null, message, "Ligar/Desligar",JOptionPane.INFORMATION_MESSAGE);
       } catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
       }
       
       String estadoLigado = Boolean.toString(mt.isLigado());
       MeioTransporteDAO.substituirEstado(estadoLigado, 1, mt);
       
       this.visualizarMeioTransporte(mt);
   }
   
   public void moverMeioTransporte(MeioTransporte mt) throws IOException{
       try {
           mt.mover();
           String message = "O " + mt.getLocomocao() + " está em movimento!";
           JOptionPane.showMessageDialog(null, message, "Mover",JOptionPane.INFORMATION_MESSAGE);
           
       } catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
       }
       
       String estadoMovendo = Boolean.toString(mt.IsMovendo());
       MeioTransporteDAO.substituirEstado(estadoMovendo, 2, mt);
       
       this.visualizarMeioTransporte(mt);
   }
   
   public void pararMeioTransporte(MeioTransporte mt) throws IOException{
       try {
           mt.parar();
           String message = "O " + mt.getLocomocao() + " está parado!";
           JOptionPane.showMessageDialog(null, message, "Mover",JOptionPane.INFORMATION_MESSAGE);
       } catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
       }
       
       String estadoMovendo = Boolean.toString(mt.IsMovendo());
       MeioTransporteDAO.substituirEstado(estadoMovendo, 2, mt);
       
       this.visualizarMeioTransporte(mt);
   }
   
   public void visualizarDadosMeioTransporte(MeioTransporte mt) throws IOException{
       String message; 
       
       
       message = mt.message();
       
       JOptionPane.showMessageDialog(null, message, "Informações do Meio de Transporte",JOptionPane.INFORMATION_MESSAGE);
       
       this.visualizarMeioTransporte(mt);
   }
   
   public void listarMeioTransporte() throws IOException{
       ArrayList linhas = MeioTransporteDAO.listarTransportesGeral();  
       MeioTransporte meiosTransporte [] = new MeioTransporte[linhas.size()];
       List <String> opcoesTransporteList = new ArrayList <>();
       
       
       opcoesTransporteList.add("Sair");
       opcoesTransporteList.add("Voltar a tela incial");              
       
       for (int i = 0; i < linhas.size(); i ++ ){
           String linha = linhas.get(i).toString();
           String linha_separada[] = linha.split(", ");           
                      
           if (linha_separada.length == 11){               
               MeioTransporte mt = new MeioTransporte (linha_separada);
               meiosTransporte[i] = mt;           
               opcoesTransporteList.add(mt.getNome());
           }                      
       }

        String [] opcoesTransporte = new String[opcoesTransporteList.size()];
        opcoesTransporte = opcoesTransporteList.toArray(opcoesTransporte);
        
        int optMenu = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opcoesTransporte, opcoesTransporte[0]);        
        
        switch (optMenu){
            case 0 -> System.exit(0);
            case 1 -> this.mostrarTelaInicial();
            default -> this.visualizarMeioTransporte(meiosTransporte[optMenu - 2]);
        }              
   }
}
