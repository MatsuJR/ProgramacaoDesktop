/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ServicoModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class ControllerServico extends ControllerFileTxt {

    private ArrayList<ServicoModel> servicos = new ArrayList<>();

    @Override
    public boolean ler(String nomeArquivo) {
        if (super.ler(nomeArquivo)) {
            String conteudo = getConteudoArquivo();
            if (conteudo != null && !conteudo.isEmpty()) {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] dados = linha.split(";");
                    if (dados.length == 3) {
                        int id = Integer.parseInt(dados[0]);
                        String descricao = dados[1];
                        String cliente = dados[2];
                        ServicoModel servico = new ServicoModel();
                        servico.setIdServico(id);
                        servico.setDescricao(descricao);
                        servico.setCliente(cliente);
                        servicos.add(servico);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean escrever(String nomeArquivo, boolean append) {
        StringBuilder conteudo = new StringBuilder();
        for (ServicoModel servico : servicos) {
            conteudo.append(servico.getIdServico()).append(";");
            conteudo.append(servico.getDescricao()).append(";");
            conteudo.append(servico.getCliente()).append("\n");
        }
        setConteudoArquivo(conteudo.toString());
        return super.escrever(nomeArquivo, append);
    }

    public void adicionarServico(int id, String descricao, String cliente) {
        File arquivoServicos = new File("servicos.txt");
        if (!arquivoServicos.exists()) {
            try {
                arquivoServicos.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        ler("servicos.txt");

        ServicoModel servico = new ServicoModel();
        servico.setIdServico(id);
        servico.setDescricao(descricao);
        servico.setCliente(cliente);

        getServicos().add(servico);

        escrever("servicos.txt", false);
    }

    public ServicoModel buscarServico(int id) {
        for (ServicoModel servico : servicos) {
            if (servico.getIdServico() == id) {
                return servico;
            }
        }
        return null;
    }

    public void alterarServico(int id, String novaDescricao, String novoCliente) {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("servicos.txt");

        StringBuilder novoConteudo = new StringBuilder();

        boolean servicoAlterado = false;

        for (String linha : controller.getConteudoArquivo().split("\n")) {
            String[] dados = linha.split(";");
            if (dados.length >= 3) {
                int idServico = Integer.parseInt(dados[0]);
                if (idServico == id) {
                    dados[1] = novaDescricao;
                    dados[2] = novoCliente;
                    servicoAlterado = true;
                }
                novoConteudo.append(dados[0]).append(";");
                novoConteudo.append(dados[1]).append(";");
                novoConteudo.append(dados[2]).append("\n");
            }
        }

        if (servicoAlterado) {
            controller.setConteudoArquivo(novoConteudo.toString());
            controller.escrever("servicos.txt", false);
        }
    }

    public void excluirServico(int idExcluir) {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("servicos.txt");

        StringBuilder novoConteudo = new StringBuilder();

        boolean servicoExcluido = false;

        for (String linha : controller.getConteudoArquivo().split("\n")) {
            String[] dados = linha.split(";");
            if (dados.length >= 3) {
                int id = Integer.parseInt(dados[0]);
                if (id == idExcluir) {
                    servicoExcluido = true;
                    continue;
                }
                novoConteudo.append(linha).append("\n");
            }
        }

        if (servicoExcluido) {
            controller.setConteudoArquivo(novoConteudo.toString());
            controller.escrever("servicos.txt", false);
        }
    }

    public String listarServicos() {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("servicos.txt");

        String conteudoArquivo = controller.getConteudoArquivo();

        if (conteudoArquivo != null && !conteudoArquivo.isEmpty()) {
            return conteudoArquivo;
        } else {
            return "está vazio";
        }
    }

    public ArrayList<ServicoModel> getServicos() {
        return servicos;
    }
}
