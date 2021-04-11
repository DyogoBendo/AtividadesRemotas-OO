/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.herancameiotransporte.DAO;
import ifpr.oo.herancameiotransporte.Models.MeioTransporte;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dyogo
 */
public class MeioTransporteDAO {
    
    private static final String NEWLINE = System.getProperty("line.separator");
    
    public static void inserir(MeioTransporte mt) throws IOException{
        File arquivo = new File(mt.getLocomocao() + ".txt");
        try{
            FileWriter fw = new FileWriter(arquivo, true);
            PrintWriter out = new PrintWriter(fw);
            out.println(mt.toString());            
            out.close();
            }          
        catch (Exception e) {  }
    }    
    
    public static void substituirEstado(String valorEstado, int posicao, MeioTransporte mt){
        try{
            File arquivo = new File(mt.getLocomocao() + ".txt");
            Scanner leitor = new Scanner (arquivo);
            List <String> data = new ArrayList <>();
            while(leitor.hasNextLine()){                
                data.add(leitor.nextLine());
            }                                               
            for (int i = 0; i < data.size(); i ++){
                String linha_estado = data.get(i);                                
                String estado [] = linha_estado.split(", ");                
                
                long definicao_id = Long.parseLong(estado[3]);
                
                if (definicao_id == mt.getId()) {
                    estado [posicao] = valorEstado;
                    String estadoTexto  = String.join(", ", estado);
                    data.set(i, estadoTexto);
                    break;
                }                                
            }
            
            String text = String.join(NEWLINE, data);            
            FileWriter fw = new FileWriter(arquivo);
            PrintWriter out = new PrintWriter(fw);
            out.println(text);
            out.close();
            
        } catch (Exception e){}           
        
    }
    
    public static ArrayList listarTransportesGeral(){
        ArrayList data = new ArrayList();
        data.addAll(MeioTransporteDAO.listarTransportesCategoria("Aviao"));
        data.addAll(MeioTransporteDAO.listarTransportesCategoria("Barco"));
        data.addAll(MeioTransporteDAO.listarTransportesCategoria("Automovel"));
        
        return data;
    }
    
    public static ArrayList listarTransportesCategoria(String locomocao){
        ArrayList data = new ArrayList();
        try{
            File arquivo = new File(locomocao + ".txt");
            Scanner leitor = new Scanner (arquivo);            
            while(leitor.hasNextLine()){
                data.add(leitor.nextLine());
            }                                                                                   
            
        } catch (Exception e){}
        return data;
    }
        
}
                   


