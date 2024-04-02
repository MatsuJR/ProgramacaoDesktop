/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Junior
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ControllerFileTxt extends ControllerFile {
    private String texto = null;
    private BufferedReader leitor = null;
    private BufferedWriter escritor = null;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean ler() {
        StringBuilder line = new StringBuilder();
        if (arquivo != null) {
            try {
                leitor = new BufferedReader(new FileReader(arquivo));
                while (leitor.ready()) {
                    line.append(leitor.readLine());
                }
                leitor.close();
                setTexto(line.toString());
                return true;
            } catch (FileNotFoundException erro) {
                System.err.println(erro.getMessage() + "Arquivo não encontrado.");
                return false;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao ler arquivo.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean escrever(boolean append) {
        if (arquivo != null) {
            try {
                escritor = new BufferedWriter(new FileWriter(arquivo, append));
                escritor.write(getTexto());
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo.");
                return false;
            }
        } else {
            return false;
        }
    }
}
