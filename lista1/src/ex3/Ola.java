/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex3;

/**
 *
 * @author Junior
 */
public class Ola {
    
    int cont=1;

    
    public void cumprimento(){
        if(cont==1){
            System.out.println("ola");
            cont++;
        }else if(cont==2){
            System.out.println("oi");
            cont++;
        }else if(cont==3){
            System.out.println("como vai?");
            cont=1;
        }
    }
}
