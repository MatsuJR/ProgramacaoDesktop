/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex4;

/**
 *
 * @author Junior
 */
public class Inteiro{

    public int valor = 0;

    public void carregaValor(int v) {
        valor = v;
    }

    public int devolveValor() {
        return valor;
    }

    public int devolveValorAbsoluto() {
        if (valor < 0) {
            return valor * -1;
        } else {
            return valor;
        }
    }

    public void imprime() {
        System.out.println(valor);
    }
}
