package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControllerFileTxt extends ControllerFile {
    protected String conteudoArquivo;

    public boolean ler(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append("\n");
            }
            conteudoArquivo = conteudo.toString();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para escrever conteúdo em um arquivo de texto
    public boolean escrever(String nomeArquivo, boolean append) {
        File arquivo = new File(nomeArquivo);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, append))) {
            bw.write(conteudoArquivo);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getConteudoArquivo() {
        return conteudoArquivo;
    }

    public void setConteudoArquivo(String conteudoArquivo) {
        this.conteudoArquivo = conteudoArquivo;
    }
}
