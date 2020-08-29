/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.oo.atividade3.zoologico;

/**
 *
 * @author Dyogo
 */
public class Zoologico {

    static Animal jaula[] = new Animal[10];
    static String nomes[] = {"Júlio", "Alípio", "Lilica", "Lola", "Zazá", "Caco", "Astolfo"};

    public static void inserir_animais() {
        int random, random_nome, random_idade;
        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * (2 - 0 + 1) + 0);
            random_nome = (int) (Math.random() * (6 - 0 + 1) + 0);
            random_idade = (int) (Math.random() * (20 - 1 + 1) + 1);
            switch (random) {
                case 0:
                    jaula[i] = new Cachorro();
                    break;
                case 1:
                    jaula[i] = new Cavalo();
                    break;
                case 2:
                    jaula[i] = new Preguica();
                    break;
                default:
                    break;
            }
            jaula[i].nome = nomes[random_nome];
            jaula[i].idade = random_idade;
        }

    }

    public static void mostrar_animais() {

        for (int i = 0; i < 10; i++) {
            System.out.print("Espécie: ");
            switch (jaula[i].id) {
                case 0:
                    System.out.println("Cachorro");
                    break;
                case 1:
                    System.out.println("Cavalo");
                    break;
                case 2: 
                    System.out.println("Preguiça");
                default:
                    break;
            }
            System.out.println("Nome: " + jaula[i].nome) ;
            System.out.println("Idade: " + jaula[i].idade + " ano(s)");
            
            jaula[i].emitirSom();
            jaula[i].correr();

            System.out.println("");
        }
    }

    public static void main(String[] args) {
        inserir_animais();
        mostrar_animais();
    }
}
