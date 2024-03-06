/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2;

/**
 *
 * @author Junior
 */
public class Aluno {
    
    public double calcmedia(double n1, double n2, double n3, double n4){
        double media = 0;
        media=(n1+n2+n3+n4)/4;
        
        return media;
    }
    
    public void aprovacao(double media){
        if(media>=6){
            System.out.println("aprovado");
        }else if(media<6&&media>=3){
            System.out.println("recuperacao");
        }else{
            System.out.println("reprovado");
        }
    }
    
}
