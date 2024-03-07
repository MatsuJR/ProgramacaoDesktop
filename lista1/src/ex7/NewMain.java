/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex7;


/**
 *
 * @author Junior
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Aluno2 aluno = new Aluno2();
       
        aluno.recebeNota1(7);
        aluno.recebeNota2(9);
        aluno.recebeNota3(5);
        aluno.recebeNota4(7);
        aluno.imprimeMedia();
        
        TestaAluno2 teste = new TestaAluno2();
        teste.testa();
    }
    
}
