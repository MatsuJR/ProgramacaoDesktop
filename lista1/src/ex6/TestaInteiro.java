/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex6;

import ex5.Inteiro2;

/**
 *
 * @author Junior
 */
public class TestaInteiro extends Inteiro2 {

    public static void main(String[] args) {
        Inteiro2 inteiro = new Inteiro2();

        inteiro.carregaValor(2);
        int valor = inteiro.devolveValor();
        inteiro.devolveValorAbsoluto();
        inteiro.imprime();
        int soma = inteiro.soma(2);
        inteiro.devolveValor();
        int subtracao = inteiro.subtrai(2);
        inteiro.imprime();
        int multiplicacao = inteiro.multiplicaPor(2);
        inteiro.imprime();
        int divisao = inteiro.dividePor(2);
        inteiro.imprime();
        divisao = inteiro.dividePor(2);
        inteiro.imprime();
        divisao = inteiro.dividePor(0);
        inteiro.imprime();
    }

}
