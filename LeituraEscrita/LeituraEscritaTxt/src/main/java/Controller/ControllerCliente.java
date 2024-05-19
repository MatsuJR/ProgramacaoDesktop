package Controller;

import Model.ClienteModel;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class ControllerCliente extends ControllerFileTxt {

    private ArrayList<ClienteModel> clientes = new ArrayList<>();

    @Override
    public boolean ler(String nomeArquivo) {
        if (super.ler(nomeArquivo)) {
            String conteudo = getConteudoArquivo();
            if (conteudo != null && !conteudo.isEmpty()) {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] dados = linha.split(";");
                    if (dados.length == 4) {
                        int id = Integer.parseInt(dados[0]);
                        String nome = dados[1];
                        String telefone = dados[2];
                        String endereco = dados[3];
                        ClienteModel cliente = new ClienteModel();
                        cliente.setId(id);
                        cliente.setNome(nome);
                        cliente.setTelefone(telefone);
                        cliente.setEndereco(endereco);
                        clientes.add(cliente);
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
        for (ClienteModel cliente : clientes) {
            conteudo.append(cliente.getId()).append(";");
            conteudo.append(cliente.getNome()).append(";");
            conteudo.append(cliente.getTelefone()).append(";");
            conteudo.append(cliente.getEndereco()).append("\n");
        }
        setConteudoArquivo(conteudo.toString());
        return super.escrever(nomeArquivo, append);
    }

    public void adicionarClienteFromView(int id, String nome, String telefone, String endereco) {
        File arquivoClientes = new File("clientes.txt");
        if (!arquivoClientes.exists()) {
            try {
                arquivoClientes.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        ler("clientes.txt");

        ClienteModel cliente = new ClienteModel();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);

        getClientes().add(cliente);

        escrever("clientes.txt", false);
    }

    public ClienteModel buscarCliente(int id) {
        ler("clientes.txt");

        for (ClienteModel cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void alterarClienteFromView(int id, String novoNome, String novoTelefone, String novoEndereco) {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("clientes.txt");

        StringBuilder novoConteudo = new StringBuilder();

        boolean clienteAlterado = false;

        for (String linha : controller.getConteudoArquivo().split("\n")) {
            String[] dados = linha.split(";");
            if (dados.length >= 4) {
                int idCliente = Integer.parseInt(dados[0]);
                if (idCliente == id) {
                    dados[1] = novoNome;
                    dados[2] = novoTelefone;
                    dados[3] = novoEndereco;
                    clienteAlterado = true;
                }
                novoConteudo.append(dados[0]).append(";");
                novoConteudo.append(dados[1]).append(";");
                novoConteudo.append(dados[2]).append(";");
                novoConteudo.append(dados[3]).append("\n");
            }
        }

        if (clienteAlterado) {
            controller.setConteudoArquivo(novoConteudo.toString());
            controller.escrever("clientes.txt", false);
        }
    }

    public void excluirClienteFromView(int idExcluir) {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("clientes.txt");

        StringBuilder novoConteudo = new StringBuilder();

        boolean clienteExcluido = false;

        for (String linha : controller.getConteudoArquivo().split("\n")) {
            String[] dados = linha.split(";");
            if (dados.length >= 4) {
                int id = Integer.parseInt(dados[0]);
                if (id == idExcluir) {
                    clienteExcluido = true;
                    continue;
                }
                novoConteudo.append(linha).append("\n");
            }
        }

        if (clienteExcluido) {
            controller.setConteudoArquivo(novoConteudo.toString());
            controller.escrever("clientes.txt", false);
        }
    }

    public String listarClientes() {
        ControllerFileTxt controller = new ControllerFileTxt();

        controller.ler("clientes.txt");

        String conteudoArquivo = controller.getConteudoArquivo();

        if (conteudoArquivo != null && !conteudoArquivo.isEmpty()) {
            return conteudoArquivo;
        } else {
            return "está vazio";
        }
    }

    public ArrayList<ClienteModel> getClientes() {
        return clientes;
    }
}
