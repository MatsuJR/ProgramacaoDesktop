/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2;

import java.util.Scanner;

/**
 *
 * @author Junior
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.println("Digite a primeira nota");
        double n1 = scanner.nextDouble();
        System.out.println("Digite a segunda nota");
        double n2 = scanner.nextDouble();
        System.out.println("Digite a terceira nota");
        double n3 = scanner.nextDouble();
        System.out.println("Digite a quarta nota");
        double n4 = scanner.nextDouble();
        
        double media=aluno.calcmedia(n1, n2, n3, n4);
        System.out.println(media);
        
        aluno.aprovacao(media);
    }

}
