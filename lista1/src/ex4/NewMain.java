/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex4;
import java.util.Scanner;
/**
 *
 * @author Junior
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inteiro inteiro = new Inteiro();
        int op=0;
        do{
            System.out.println("Digite 1 para mudar o valor");
            System.out.println("Digite 2 para devolver o valor");
            System.out.println("Digite 3 para devolver o valor absoluto");
            System.out.println("Digite 4 para imprimir o valor");
            System.out.println("Digite 5 para sair");
            op = scanner.nextInt();
            if(op==1){
                System.out.println("Digite o valor");
                int v = scanner.nextInt();
                inteiro.carregaValor(v);
            }
            if(op==2){
                System.out.println(inteiro.devolveValor());
            }
            if(op==3){
                System.out.println(inteiro.devolveValorAbsoluto());
            }
            if(op==4){
                inteiro.imprime();
            }if(op==5){
                System.out.println("saindo");
            }
        }while(op!=5);
    }
    
}
