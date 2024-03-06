/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex1;

/**
 *
 * @author Junior
 */
import java.util.Scanner;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Conversor5 conversor5 = new Conversor5();
        double valor = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("escolha uma opcao de conversao");

        System.out.print("1- Celsius para Fahrenheit\n");
        System.out.print("2- Celsius para Kelvin\n");
        System.out.print("3- Fahrenheit para Celsius\n");
        System.out.print("4- Fahrenheit para Kelvin\n");
        System.out.print("5- Kelvin para Celsius\n");
        System.out.print("6- Kelvin para Fahrenheit\n");
        System.out.print("7- SAIR\n");

        int opcao = scanner.nextInt();

        System.out.println("Digite a temperatura que sera convertida\n");
        double temp = scanner.nextDouble();

        switch (opcao) {
            case 1:
                valor = conversor5.CF(temp);
                System.out.println(valor);
                break;

            case 2:
                valor = conversor5.CK(temp);
                System.out.println(valor);
                break;

            case 3:
                valor = conversor5.FC(temp);
                System.out.println(valor);
                break;

            case 4:
                valor = conversor5.FK(temp);
                System.out.println(valor);
                break;

            case 5:
                valor = conversor5.KC(temp);
                System.out.println(valor);
                break;

            case 6:
                valor = conversor5.KF(temp);
                System.out.println(valor);
                break;

            case 7:
                System.out.print("\nAté logo!");
                scanner.close();

            default:
                System.out.print("\nOpção Inválida!");
                break;
        }
    }

}
