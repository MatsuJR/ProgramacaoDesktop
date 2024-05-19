package Controller;

import Model.FuncionarioModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerFuncionario extends ControllerFileTxt {

    private ArrayList<FuncionarioModel> funcionarios = new ArrayList<>();

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
                        String nome = dados[1];
                        String cargo = dados[2];
                        FuncionarioModel funcionario = new FuncionarioModel();
                        funcionario.setIdFuncionario(id);
                        funcionario.setNomeFuncionario(nome);
                        funcionario.setCargo(cargo);
                        funcionarios.add(funcionario);
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
        for (FuncionarioModel funcionario : funcionarios) {
            conteudo.append(funcionario.getIdFuncionario()).append(";");
            conteudo.append(funcionario.getNomeFuncionario()).append(";");
            conteudo.append(funcionario.getCargo()).append("\n");
        }
        setConteudoArquivo(conteudo.toString());
        return super.escrever(nomeArquivo, append);
    }

    public void adicionarFuncionario(int id, String nome, String cargo) {
        File arquivoFuncionarios = new File("funcionarios.txt");
        if (!arquivoFuncionarios.exists()) {
            try {
                arquivoFuncionarios.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        ler("funcionarios.txt");

        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setIdFuncionario(id);
        funcionario.setNomeFuncionario(nome);
        funcionario.setCargo(cargo);

        getFuncionarios().add(funcionario);

        escrever("funcionarios.txt", false);
    }

    public FuncionarioModel buscarFuncionario(int id) {
        ler("funcionarios.txt");
        
        for (FuncionarioModel funcionario : funcionarios) {
            if (funcionario.getIdFuncionario() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void alterarFuncionario(int id, String novoNome, String novoCargo) {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("funcionarios.txt");

        StringBuilder novoConteudo = new StringBuilder();

        boolean funcionarioAlterado = false;

        for (String linha : controller.getConteudoArquivo().split("\n")) {
            String[] dados = linha.split(";");
            if (dados.length >= 3) {
                int idFuncionario = Integer.parseInt(dados[0]);
                if (idFuncionario == id) {
                    dados[1] = novoNome;
                    dados[2] = novoCargo;
                    funcionarioAlterado = true;
                }
                novoConteudo.append(dados[0]).append(";");
                novoConteudo.append(dados[1]).append(";");
                novoConteudo.append(dados[2]).append("\n");
            }
        }

        if (funcionarioAlterado) {
            controller.setConteudoArquivo(novoConteudo.toString());
            controller.escrever("funcionarios.txt", false);
        }
    }

    public void excluirFuncionario(int idExcluir) {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("funcionarios.txt");

        StringBuilder novoConteudo = new StringBuilder();

        boolean funcionarioExcluido = false;

        for (String linha : controller.getConteudoArquivo().split("\n")) {
            String[] dados = linha.split(";");
            if (dados.length >= 3) {
                int id = Integer.parseInt(dados[0]);
                if (id == idExcluir) {
                    funcionarioExcluido = true;
                    continue;
                }
                novoConteudo.append(linha).append("\n");
            }
        }

        if (funcionarioExcluido) {
            controller.setConteudoArquivo(novoConteudo.toString());
            controller.escrever("funcionarios.txt", false);
        }
    }

    public String listarFuncionarios() {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("funcionarios.txt");

        String conteudoArquivo = controller.getConteudoArquivo();

        if (conteudoArquivo != null && !conteudoArquivo.isEmpty()) {
            return conteudoArquivo;
        } else {
            return "está vazio";
        }
    }

    public ArrayList<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }
}
