/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex5;

/**
 *
 * @author Junior
 */

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
        Inteiro2 inteiro2 = new Inteiro2();
        int v = 0;
        int op = 0;
        do {
            System.out.println("Digite 1 para mudar o valor");
            System.out.println("Digite 2 para devolver o valor");
            System.out.println("Digite 3 para devolver o valor absoluto");
            System.out.println("Digite 4 para imprimir o valor");
            System.out.println("Digite 5 para somar um valor");
            System.out.println("Digite 6 para subtrair um valor");
            System.out.println("Digite 7 para multiplicar um valor");
            System.out.println("Digite 8 para subtrair um valor");
            System.out.println("Digite 9 para sair");

            op = scanner.nextInt();
            if (op == 1) {
                System.out.println("Digite o valor");
                v = scanner.nextInt();
                inteiro2.carregaValor(v);
            }
            if (op == 2) {
                System.out.println(inteiro2.devolveValor());
            }
            if (op == 3) {
                System.out.println(inteiro2.devolveValorAbsoluto());
            }
            if (op == 4) {
                inteiro2.imprime();
            }
            if (op == 5) {
                System.out.println("Digite o valor a ser somado");
                v = scanner.nextInt();
                System.out.println(inteiro2.soma(v));
            }
            if (op == 6) {
                System.out.println("Digite o valor a ser subtraido");
                v = scanner.nextInt();
                System.out.println(inteiro2.subtrai(v));
            }
            if (op == 7) {
                System.out.println("Digite o valor a ser multiplicado");
                v = scanner.nextInt();
                System.out.println(inteiro2.multiplicaPor(v));
            }
            if (op == 8) {
                System.out.println("Digite o valor a ser dividido");
                v = scanner.nextInt();
                System.out.println(inteiro2.dividePor(v));
            }
            if (op == 9) {
                System.out.println("saindo");
            }
        } while (op != 9);
    }

}
