/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex7;

/**
 *
 * @author Junior
 */
public class Aluno2 {

    public double notatotal = 0;

    public void recebeNota1(double nota1) {
        notatotal = notatotal + nota1;
    }

    public void recebeNota2(double nota2) {
        notatotal = notatotal + nota2;
    }

    public void recebeNota3(double nota3) {
        notatotal = notatotal + nota3;

    }

    public void recebeNota4(double nota4) {
        notatotal = notatotal + nota4;

    }

    public void imprimeMedia() {
        System.out.println("media"+notatotal/4);
        if(notatotal/4 >= 6){
            System.out.println("Aprovado");
        }else{
            System.out.println("Reprovado");
        }
        
    }

}
