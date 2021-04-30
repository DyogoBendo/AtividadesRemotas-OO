
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dyogo
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Vendedor v1 = new Vendedor();                        
        EquipeVenda eq1 = new EquipeVenda();
        Endereco e1 = new Endereco();
        Cidade c1 = new Cidade();
        Estado estado1 = new Estado();        
        
        eq1.setNome("Time Estelar");
        
        
        String data1 = "2000-01-18";
        Date dn1 = new SimpleDateFormat("yyyyy-MM-dd").parse(data1);
        
        estado1.setNome("Paraná");
        estado1.setSigla("PR");
        
        c1.setEstado(estado1);
        c1.setNome("Santa Terezinha de Itaipu");
        
        e1.setBairro("Parque dos Estados");
        e1.setCep("85875-000");
        e1.setCidade(c1);
        e1.setNumero(232);
        e1.setRua("Rua Amazonas");        
                
        v1.setNome("Josevaldo");
        v1.setCpf("143.342.982-91");                
        v1.setEndereco(e1);
        v1.setNascimento(dn1);      
        v1.setEquipe(eq1);
        
        System.out.println(v1);
        
        Gerente g1 = new Gerente();        
        Endereco e2 = new Endereco();
        Cidade c2 = new Cidade();
        Estado estado2 = new Estado();        
        String data2 = "1983-08-11";
        Date dn2 = new SimpleDateFormat("yyyyy-MM-dd").parse(data2);         
        
        estado2.setNome("Santa Catarina");
        estado2.setSigla("SC");
        
        c2.setEstado(estado2);
        c2.setNome("Chapecó");
        
        e2.setBairro("Santa Maria");
        e2.setCep("21370-912");
        e2.setCidade(c2);
        e2.setNumero(456);
        e2.setRua("Rua das Bonitas");
        
        g1.setNome("Palona");
        g1.setCpf("123.456.789-10");
        g1.setEndereco(e2);
        g1.setNascimento(dn2);
        
        System.out.println(g1);
        
        Vendedor v2= new Vendedor();                                
        Endereco e3 = new Endereco();                       
        eq1.setNome("Time Estelar");        
        
        String data3 = "1999-07-24";
        Date dn3 = new SimpleDateFormat("yyyyy-MM-dd").parse(data3);
                                
        
        e3.setBairro("Centro");
        e3.setCep("85875-000");
        e3.setCidade(c1);
        e3.setNumero(400);
        e3.setRua("Rua das Comunicações");        
                
        v2.setNome("Franascisco");
        v2.setCpf("111.222.333-40");                
        v2.setEndereco(e3);
        v2.setNascimento(dn3);      
        v2.setEquipe(eq1);
        
        System.out.println(v2);                                                        
        
    }
}
