/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex3;
import java.util.Scanner;
/**
 *
 * @author Junior
 */
public class NewMain {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Ola ola = new Ola();
        int op=0;
        int cont=0;
        
        do {
            System.out.println("Digite o numero 1 para chamar o cumprimento");
            System.out.println("Digite o numero 2 para sair");
            op=scanner.nextInt();
            if(op!=1 && op!=2){
                System.out.println("opcao invalida");
            }
            if(op==1){
                ola.cumprimento();
            }
            
        }while(op!=2);
        System.out.println("Saindo");
        
    }

}
